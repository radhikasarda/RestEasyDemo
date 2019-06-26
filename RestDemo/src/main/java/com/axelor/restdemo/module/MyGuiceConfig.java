package com.axelor.restdemo.module;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MyGuiceConfig extends GuiceResteasyBootstrapServletContextListener{

  @Override
  protected List<? extends Module> getModules(ServletContext context)
  {
      return (List<? extends Module>) Arrays.asList(new JpaPersistModule("axelor"), new GuiceModule());
  }
  
  @Override
  public void withInjector(Injector injector)
  {
      injector.getInstance(PersistService.class).start();
  }
  
}
