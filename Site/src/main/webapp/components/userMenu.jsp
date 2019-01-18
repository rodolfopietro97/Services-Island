<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="sidebar-nav">
	<div class="sidebar-header">
		<button class="nav-toggler nav-toggler-md sidebar-toggler"
			type="button" data-toggle="collapse" data-target="#nav-toggleable-md">
			<span class="sr-only">Toggle nav</span>
		</button>

	</div>
	<br> <br>
	<div class="collapse nav-toggleable-md" id="nav-toggleable-md">
		<form class="sidebar-form">
			<input class="form-control" type="text" placeholder="Search...">
			<button type="submit" class="btn-link">
				<span class="fas fa-search"></span>
			</button>
		</form>
		<ul class="nav nav-pills nav-stacked flex-column">
			<li class="nav-header">Menu</li>
			<li class="nav-item"><a class="nav-link active"
				href="../index-light/index.html">Home</a></li>


			<li class="nav-header">User Menu</li>



		</ul>
		<hr class="visible-xs mt-3">
	</div>
</nav>


