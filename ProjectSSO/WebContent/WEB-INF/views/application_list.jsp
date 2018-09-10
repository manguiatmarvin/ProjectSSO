<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Project SSO - Single Sign On Module </title>
     <link href="<c:url value="/resources/css/dashboard/dashboard.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
  </head>
<script>
//A $( document ).ready() block.
$( document ).ready(function() {
  
});
</script>
  <body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Project SSO</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          
          <a class="nav-link" href="#" data-toggle="modal" data-target="#confirm-logout-modal">Log out</a>
         
        </li>
      </ul>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link" href="./">
                  <span data-feather="home"></span>
                  Dashboard
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="./application_list">
                  <span data-feather="file"></span>
                  Application List <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="shopping-cart"></span>
                  Account
                </a>
              </li>
            </ul>
          </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Application List</h1>
            <div class="btn-toolbar mb-2 mb-md-1">
              <div class="btn-group mr-2">
                <button class="btn btn-sm  btn-primary">Add New</button>
              </div>
            </div>
          </div>
          
          <div>
          <c:if test="${not empty user.getClientCredential()}">
		   <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Application</th>
                  <th>Client ID</th>
                  <th>Client Secret</th>
                  <th>Redirect URL</th>
                  <th>IS Active</th>
                </tr>
              </thead>
			 <tbody>
			   
			 <c:forEach var="listItems" items="${user.getClientCredential()}">
			 <tr>
                  <td>${listItems.getId()}</td>
                  <td><a href="<spring:url value="/edit_application?appid=${listItems.getId()}"/>" title="${listItems.getApplicationName()}">${listItems.getApplicationName()}</a></td>
                  <td>${listItems.getClientId()}</td>
                  <td>${listItems.getClientSecret()}</td>
                  <td>${listItems.getCallBackUrl()}</td>   
                  <td><input type="checkbox" name="selected" ${listItems.isActive() ? "checked":"" } disabled></td>
                <tr>
              </c:forEach>
             </tbody>
		  </c:if>
          </div>
        </main>
      </div>
    </div>
    
    
  <!-- ## Modals -->
  <div class="modal fade" id="confirm-logout-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirm Logout</h5>
       </div>
				<div class="modal-body">
					<div class="card">
						<div class="card-body">
							<small>Are you sure you want to logout?</small>
						</div>
					</div>
				</div>
				<div class="modal-footer">
        <div>
        <a class="d-inline btn btn-primary btn-sm" href="<spring:url value="/logout"/>">Yes</a>
        <a class="d-inline btn btn-secondary btn-sm" href="#" data-dismiss="modal" >No</a>
        </div>
        
      </div>
    </div>
  </div>
</div>  
  </body>
</html>
