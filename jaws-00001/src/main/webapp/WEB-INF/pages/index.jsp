<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OWASP JAWS</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="navbar navbar-fixed-top navbar-default" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">OWASP JAWS</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div class="well sidebar-nav">
            <ul class="nav">
              <li>Injection</li>
              <li class="active"><a href="#">SQL</a></li>
              <li><a href="#">LDAP</a></li>
              <li><a href="#">OS Command</a></li>
              <li>XSS</li>
              <li><a href="#">Reflected</a></li>
              <li><a href="#">Stored</a></li>
              <li><a href="#">Dom</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
	    <div style="clear:both; width: 0; height: 0">&nbsp;</div>
            <a href="#good" data-toggle="tab"><div class="col-xs-6 alert alert-success text-center">Good</div></a>
            <a href="#bad" data-toggle="tab"><div class="col-xs-6 alert alert-danger text-center">Bad</div></a>
          <div class="tab-content">
            <div class="tab-pane active" id="good">
              <div><p>Bacon ipsum dolor sit amet hamburger ball tip shank biltong flank ground round pork belly cow corned beef.  Flank venison tongue corned beef pancetta.  Corned beef tongue pork loin t-bone biltong andouille, pork salami filet mignon prosciutto leberkas kevin ham hock shank.  Tri-tip short loin drumstick ham hock.  Tri-tip meatloaf t-bone beef, rump pastrami drumstick jowl tail kielbasa cow flank ham hock prosciutto.  Jowl beef ribs swine turkey boudin kielbasa pork belly strip steak pork loin drumstick short ribs sirloin pancetta t-bone.  Shankle shank tenderloin doner salami pancetta.</p><p>Rump chicken flank spare ribs, tenderloin bacon biltong jerky kevin tri-tip ground round t-bone ham hock pork.  Sirloin short loin tenderloin filet mignon strip steak.  Fatback pastrami biltong shankle leberkas meatloaf, turducken drumstick pancetta ground round.  Spare ribs turducken pork chop brisket short loin swine.  Pork loin tongue ham hock beef ribs.  Prosciutto pork chop filet mignon, corned beef ham hock venison pork jowl biltong.</p><p>Fatback short loin pork tri-tip salami turducken short ribs chuck ground round biltong ham.  T-bone pastrami cow andouille.  Brisket beef ribs sausage t-bone fatback pastrami.  Hamburger tenderloin leberkas doner chicken, bresaola kevin tri-tip drumstick.  Jowl pig frankfurter venison pastrami pork.  Pork chop t-bone cow beef filet mignon beef ribs boudin spare ribs short loin.  Rump leberkas tenderloin pork chop meatloaf.</p><p>Ham ham hock drumstick tail sausage, meatball frankfurter spare ribs kielbasa pork chop.  Venison capicola doner, frankfurter tenderloin shank short ribs chuck bresaola ground round.  Frankfurter corned beef andouille strip steak rump spare ribs salami sausage turkey t-bone shankle prosciutto ground round.  Prosciutto shank corned beef, filet mignon t-bone ribeye jerky sausage hamburger.  Kielbasa ribeye pancetta, kevin spare ribs filet mignon shoulder tri-tip brisket ball tip shank pork chop ham hock leberkas.  Ham hock ground round biltong corned beef tri-tip pork chop.</p><p>Cow kielbasa doner tenderloin prosciutto short loin sausage turducken chuck fatback brisket beef.  Pancetta turducken ham shankle shank biltong pork loin.  Corned beef kielbasa sirloin boudin t-bone meatball ground round.  Prosciutto brisket venison, boudin drumstick strip steak salami pork belly ham hock.  Pork belly ham hock short ribs drumstick meatball.  Pancetta sausage pork t-bone biltong turkey boudin drumstick pork chop kielbasa andouille bacon beef ham tongue.</p></div>              
            </div>
            <div class="tab-pane" id="bad">
              <div><p>Bacon ipsum dolor sit amet hamburger ball tip shank biltong flank ground round pork belly cow corned beef.  Flank venison tongue corned beef pancetta.  Corned beef tongue pork loin t-bone biltong andouille, pork salami filet mignon prosciutto leberkas kevin ham hock shank.  Tri-tip short loin drumstick ham hock.  Tri-tip meatloaf t-bone beef, rump pastrami drumstick jowl tail kielbasa cow flank ham hock prosciutto.  Jowl beef ribs swine turkey boudin kielbasa pork belly strip steak pork loin drumstick short ribs sirloin pancetta t-bone.  Shankle shank tenderloin doner salami pancetta.</p><p>Rump chicken flank spare ribs, tenderloin bacon biltong jerky kevin tri-tip ground round t-bone ham hock pork.  Sirloin short loin tenderloin filet mignon strip steak.  Fatback pastrami biltong shankle leberkas meatloaf, turducken drumstick pancetta ground round.  Spare ribs turducken pork chop brisket short loin swine.  Pork loin tongue ham hock beef ribs.  Prosciutto pork chop filet mignon, corned beef ham hock venison pork jowl biltong.</p></div></div>
            </div>
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title">Documentation</h3>
              </div>
              <div class="panel-body">
                Documentation here
              </div>
            </div>
            <div class="panel panel-info">
              <div class="panel-heading">
                <h3 class="panel-title">External sources</h3>
              </div>
              <div class="panel-body">
                http://owasp.org
              </div>
            </div>
        </div><!--/span-->

      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; OWASP 2013</p>
      </footer>

    </div><!--/.container-->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/javascript.js"></script>
  </body>
</html>