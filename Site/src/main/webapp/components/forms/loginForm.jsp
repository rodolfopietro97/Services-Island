<div class="col-md-3 offset-md-3 float-right" style="margin-top: 50px;">

	<form class="px-4 py-3" method="POST" action="UserHandler?op=login">
		<div class="form-group">
			<label for="exampleDropdownFormEmail1">Email address</label> <input
				name="txtEmail" type="email" class="form-control"
				id="exampleDropdownFormEmail1" placeholder="email@example.com"
				style="min-width: 150px;">
		</div>
		<div class="form-group">
			<label for="exampleDropdownFormPassword1">Password</label> <input
				name="txtPassword" type="password" class="form-control"
				id="exampleDropdownFormPassword1" placeholder="Password"
				style="min-width: 150px;">
		</div>

		<div style="">
			<ul>
				<li style="float: left; list-style-type: none; margin: 2px;"><a
					href="#registration" class="btn btn-primary float-right">Sing
						Up</a></li>
			</ul>
			<ul>
				<li style="float: left; list-style-type: none; margin: 2px;">
					<button type="submit" class="btn btn-primary float-right">Login</button>
				</li>
			</ul>
		</div>
	</form>
</div>