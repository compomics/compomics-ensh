package com.compomics.ensh.playground;

import com.compomics.ensh.Ensh;
import com.compomics.ensh.core.AnalysisEntity;
import com.compomics.ensh.exception.EnshException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//import com.compomics.ensh.module.model.Component;
//import com.compomics.ensh.module.model.Module;
//import com.compomics.ensh.module.model.impl.Complex;
//import com.compomics.ensh.module.model.impl.ProteinComponent;

/**
 * @TODO: JavaDoc missing
 * @TODO: all code in this class has been commented out...
 * <p/>
 * Created by IntelliJ IDEA.<br/>
 * User: mmueller<br/>
 * Date: 14-Dec-2007<br/>
 * Time: 11:30:55<br/>
 */
public class EnshApp {

    public static void main(String[] args) {


        try {

            SessionFactory sessionFactory = Ensh.getSessionFactory(9606, 63);

            Session session = sessionFactory.openSession();

            Query q = session.createQuery("from AnalysisEntity");
            Iterator iterator = q.iterate();

            Set<Component> components = new HashSet<Component>();

            session.beginTransaction();
//            ModuleSource ms = new ModuleSourceImpl();
//            ms.setName("test");
//            session.saveOrUpdate(ms);

            int counter = 0;
            while (iterator.hasNext()) {

//                TranslationEntity lTranslationEntity = (TranslationEntity) iterator.next();
                AnalysisEntity lAnalysisEntity = (AnalysisEntity) iterator.next();
                System.out.println(lAnalysisEntity.getDb());

//                Component pc = new ProteinComponent((Translation) o);
//
//                System.out.println(pc.getObject());
//
//                session.save(pc);
//
//                components.add(pc);

                if (++counter % 10 == 0) {

                    System.out.println("persisting module");
                    System.out.println("Components " + components);
//                    Module m = new Complex("complex_" + counter, 0);

//                    for(Component c : components){
//                        m.addComponent(c);
//                    }
//
//                    //m.setModuleSource(ms);
//
//                    session.save(m);

                    components.clear();

                }

                if (counter == 100) {
                    break;
                }
            }

            session.getTransaction().commit();


            System.exit(1);

        } catch (EnshException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
