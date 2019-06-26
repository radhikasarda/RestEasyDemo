package com.axelor.restdemo.module;

import com.axelor.restdemo.service.Service;
import com.axelor.restdemo.service.ServiceImpl;
import com.axelor.restdemo.web.Controller;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
  
  bind(Controller.class);
  bind(Service.class).to(ServiceImpl.class);

  } 
  
} 
  
  

