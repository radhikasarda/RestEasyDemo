package com.axelor.restdemo.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.axelor.restdemo.domain.Employee;
import com.axelor.restdemo.service.Service;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/")
public class Controller {

  @Inject Service service;

  @GET
  public void showEmployees(
      @Context HttpServletRequest request, @Context HttpServletResponse response)
      throws ServletException, IOException {
    List<Employee> employeeList = service.showAllEmployees();
    System.out.println("inside controller");
    request.setAttribute("listUser", employeeList);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  @Path("/add")
  @POST
  public void insert(
      @FormParam("name") String name,
      @FormParam("contact") String contact,
      @FormParam("city") String address,
      @Context HttpServletRequest request,
      @Context HttpServletResponse response)
      throws ServletException, IOException {

    service.insert(name, contact, address);
    //  request.getRequestDispatcher("/index.jsp").forward(request, response);

    showEmployees(request, response);
  }

  @Path("/delete")
  @GET
  public void deleteemployee(
      @QueryParam("id") int id,
      @Context HttpServletRequest request,
      @Context HttpServletResponse response)
      throws ServletException, IOException {

   
    service.delete(id);
    showEmployees(request, response);
  }


}
