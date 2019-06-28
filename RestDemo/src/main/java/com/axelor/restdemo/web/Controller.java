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

	@Inject
	Service service;

	
	@GET
	public void showEmployees(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws ServletException, IOException {

		List<Employee> allEmployeeList = service.showAllEmployees();
		request.setAttribute("listEmployee", allEmployeeList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Path("/add")
	@POST
	public void insert(@FormParam("name") String name, @FormParam("contact") String[] contact,
			@FormParam("city") String address, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {

		service.insert(name, contact, address);
		response.sendRedirect(request.getContextPath());
	}

	@Path("/delete")
	@GET
	public void deleteEmployee(@QueryParam("id") int id, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {

		service.delete(id);
		response.sendRedirect(request.getContextPath());
	}


	@Path("/edit")
	@GET
	public void editEmployee(@QueryParam("id") int id, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {

		Employee employee = service.edit(id);	
		request.setAttribute("employeeDetails", employee);
		System.out.println("Inside controller edit"+employee);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);

	}
	
	

	@Path("/update")
	@POST
	public void updateEmployee(@QueryParam("id") int id, @FormParam("updatedName") String name,
			@FormParam("updatedContact") String contact, @FormParam("updatedCity") String address,
			@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("inside update controller"+"id="+id+"name="+name+"contact="+contact+"address="+address);
		service.update(id, name, contact, address);
		response.sendRedirect(request.getContextPath());

	}

	@Path("/search")
	@POST
	public void searchEmployee(@FormParam("searchedName") String searchedName, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {

		List<Employee> searchedEmployee = service.search(searchedName);
		request.setAttribute("detailList", searchedEmployee);
		request.getRequestDispatcher("/search.jsp").forward(request, response);

	}

}
