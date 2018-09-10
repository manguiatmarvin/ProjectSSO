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
                  Application List<span class="sr-only">(current)</span>
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
            <h1 class="h2">Edit Application</h1>
            <div class="btn-toolbar mb-2 mb-md-1">
              <div class="btn-group mr-2">
                <button class="btn btn-sm  btn-primary mr-3">Update</button>
                <button class="btn btn-sm  btn-primary mr-3">Cancel</button>
              </div>
            </div>
          </div>
          
          <div>
           <c:if test="${not empty clientCredential}">
		   <p>${clientCredential.getApplicationName()}</p>
			
			 <div class="row">
				<div class="col-sm-8">
				<div class="row">
				 <div class="col-md-6 mb-3">
				 <label for="application_name">Application Name</label>
                <input type="text" class="form-control" id="application_name" name="application_name" placeholder="Application Name" value="${clientCredential.getApplicationName()}" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
				 </div>
				  <div class="col-md-6 mb-3">
				     <label for="redirect-url">Redirect URL</label>
                <input type="text" class="form-control" id="redirect-url"  name="redirect-url" placeholder="Redirect URL" value="${clientCredential.getCallBackUrl()}" required>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
				 </div>
				</div>
				
			<div class="row">
				<div class="col-md-12 mb-3">
				 <label for="description">Application Description</label>
                 <textarea name="description" id="description" class="form-control" style="min-width: 100%;height:95px"></textarea>
                <div class="invalid-feedback">
                  Valid Description is required.
                </div>
				 </div>
				</div>
				
			<div class="row">
				 <div class="col-md-6 mb-3">
				 <label for="firstName">Generated Application ID</label>
                <input type="text" class="form-control" id="application_id" placeholder="Application ID" value="${clientCredential.getClientId()}" required disabled>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
				 </div>
				  <div class="col-md-6 mb-3">
				     <label for="firstName">Generated Application Secret</label>
                <textarea name="application_secret" id="application_secret" class="form-control" style="min-width: 100%;height:95px" required disabled>
                ${clientCredential.getClientSecret()}
                </textarea>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
                
                <p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				<p>asdasdakhsgdasjd</p>
				
				 </div>
				</div>
				
				
				
				</div>
				<div class="col-sm-4">
				 <ul class="section-nav">
<li class="toc-entry toc-h2"><a href="#common-values">Common values</a></li>
<li class="toc-entry toc-h2"><a href="#fixed-top">Fixed top</a></li>
<li class="toc-entry toc-h2"><a href="#fixed-bottom">Fixed bottom</a></li>
<li class="toc-entry toc-h2"><a href="#sticky-top">Sticky top</a></li>
</ul>
				
				</div>
			  <div>
			  


        </div>
					
			 </div>
		  
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
