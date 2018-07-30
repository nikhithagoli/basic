<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <title>Registration Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="wnameth=device-wnameth, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
  <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css' />
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,250' rel='stylesheet' type='text/css' />
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/js/bootstrap.min.js">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link href="assets/css/mycss.css" rel="stylesheet">

</head>

<body>
  <div class="container">
    <h1 style="text-align:center; margin-top:15px;">Registration FORM</h1>
    <div class="Form" style="margin-top:30px;">
      <form action="otpverify.php" method="post">
        <div class="row form-group">

          <div class="col-md-4 right">
            <label for="exampleFormControlInput1">Name</label></div>
          <div class="col-md-4 left">
            <input type="text" class="form-control" name="name" placeholder="Name" value=""  required>
          </div>
        </div>
        <div class="row form-group">
          <div class="col-md-4 right">
            <label for="exampleFormControlInput1">Last name</label></div>
          <div class="col-md-4 left">
            <input type="text" class="form-control" name="last" placeholder="Last Namne" value=""  required>
          </div>
        </div>
        <div class="row form-group">
          <div class="col-md-4 right">
            <label for="exampleFormControlInput1">Email</label></div>
          <div class="col-md-4 left">
            <input type="email" class="form-control" name="email" placeholder="name@example.com" value=""  required>
          </div>
        </div>
        <div class="row form-group">
          <div class="col-md-4 right">
            <label for="exampleFormControlInput1">Phone NUmber</label></div>
          <div class="col-md-4 left">
            <input type="text" class="form-control" name="phno" placeholder="123454789" value=""  required>
          </div>
        </div>
        <div class=row>
          <div class="col-md-12">
            <button type="submit" class="btn btn-primary" name="submit">Submit</button>
          </div>
      </form>
      </div>
    </div>

</body>
</html>
