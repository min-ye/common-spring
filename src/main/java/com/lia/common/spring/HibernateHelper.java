package com.lia.common.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
   private static final Log log=LogFactory.getLog(HibernateHelper.class);

   private static final SessionFactory sessionFactory;
   static
   {
      try {
         sessionFactory=new Configuration().configure().buildSessionFactory();
      }
      catch(Throwable ex) {
         log.error("Initial SessionFactory creation failed.",ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static final ThreadLocal thread_var=new ThreadLocal();

   public static Session currentSession()
   {
      Session s=(Session)thread_var.get();
      if(s==null) {
        s=sessionFactory.openSession();
        thread_var.set(s);
      }
      return s;
   }

   public static void closeSession()
   {
      Session s=(Session)thread_var.get();
      if(s!=null)
         s.close();
      thread_var.set(null);
   }
}
