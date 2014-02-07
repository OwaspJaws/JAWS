<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div class="col-xs-12 col-sm-9">
    <p class="pull-right visible-xs">
        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
    </p>
    <div style="clear:both; width: 0; height: 0">&nbsp;</div>
    <a href="#good" data-toggle="tab">
        <div class="col-xs-6 alert alert-success text-center">Good</div>
    </a>
    <a href="#bad" data-toggle="tab">
        <div class="col-xs-6 alert alert-danger text-center">Bad</div>
    </a>

    <div class="tab-content">
        <div class="tab-pane active" id="good">
            <div><p>Bacon ipsum dolor sit amet hamburger ball tip shank biltong flank ground round pork belly
                cow corned beef. Flank venison tongue corned beef pancetta. Corned beef tongue pork loin t-bone
                biltong andouille, pork salami filet mignon prosciutto leberkas kevin ham hock shank. Tri-tip
                short loin drumstick ham hock. Tri-tip meatloaf t-bone beef, rump pastrami drumstick jowl tail
                kielbasa cow flank ham hock prosciutto. Jowl beef ribs swine turkey boudin kielbasa pork belly
                strip steak pork loin drumstick short ribs sirloin pancetta t-bone. Shankle shank tenderloin
                doner salami pancetta.</p>

                <p>Rump chicken flank spare ribs, tenderloin bacon biltong jerky kevin tri-tip ground round
                    t-bone ham hock pork. Sirloin short loin tenderloin filet mignon strip steak. Fatback
                    pastrami biltong shankle leberkas meatloaf, turducken drumstick pancetta ground round. Spare
                    ribs turducken pork chop brisket short loin swine. Pork loin tongue ham hock beef ribs.
                    Prosciutto pork chop filet mignon, corned beef ham hock venison pork jowl biltong.</p>

                <p>Fatback short loin pork tri-tip salami turducken short ribs chuck ground round biltong ham.
                    T-bone pastrami cow andouille. Brisket beef ribs sausage t-bone fatback pastrami. Hamburger
                    tenderloin leberkas doner chicken, bresaola kevin tri-tip drumstick. Jowl pig frankfurter
                    venison pastrami pork. Pork chop t-bone cow beef filet mignon beef ribs boudin spare ribs
                    short loin. Rump leberkas tenderloin pork chop meatloaf.</p>

                <p>Ham ham hock drumstick tail sausage, meatball frankfurter spare ribs kielbasa pork chop.
                    Venison capicola doner, frankfurter tenderloin shank short ribs chuck bresaola ground round.
                    Frankfurter corned beef andouille strip steak rump spare ribs salami sausage turkey t-bone
                    shankle prosciutto ground round. Prosciutto shank corned beef, filet mignon t-bone ribeye
                    jerky sausage hamburger. Kielbasa ribeye pancetta, kevin spare ribs filet mignon shoulder
                    tri-tip brisket ball tip shank pork chop ham hock leberkas. Ham hock ground round biltong
                    corned beef tri-tip pork chop.</p>

                <p>Cow kielbasa doner tenderloin prosciutto short loin sausage turducken chuck fatback brisket
                    beef. Pancetta turducken ham shankle shank biltong pork loin. Corned beef kielbasa sirloin
                    boudin t-bone meatball ground round. Prosciutto brisket venison, boudin drumstick strip
                    steak salami pork belly ham hock. Pork belly ham hock short ribs drumstick meatball.
                    Pancetta sausage pork t-bone biltong turkey boudin drumstick pork chop kielbasa andouille
                    bacon beef ham tongue.</p></div>
        </div>
        <div class="tab-pane" id="bad">
            <div><p>Bacon ipsum dolor sit amet hamburger ball tip shank biltong flank ground round pork belly
                cow corned beef. Flank venison tongue corned beef pancetta. Corned beef tongue pork loin t-bone
                biltong andouille, pork salami filet mignon prosciutto leberkas kevin ham hock shank. Tri-tip
                short loin drumstick ham hock. Tri-tip meatloaf t-bone beef, rump pastrami drumstick jowl tail
                kielbasa cow flank ham hock prosciutto. Jowl beef ribs swine turkey boudin kielbasa pork belly
                strip steak pork loin drumstick short ribs sirloin pancetta t-bone. Shankle shank tenderloin
                doner salami pancetta.</p>

                <p>Rump chicken flank spare ribs, tenderloin bacon biltong jerky kevin tri-tip ground round
                    t-bone ham hock pork. Sirloin short loin tenderloin filet mignon strip steak. Fatback
                    pastrami biltong shankle leberkas meatloaf, turducken drumstick pancetta ground round. Spare
                    ribs turducken pork chop brisket short loin swine. Pork loin tongue ham hock beef ribs.
                    Prosciutto pork chop filet mignon, corned beef ham hock venison pork jowl biltong.</p></div>
        </div>
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
</div>

<%@include file="/WEB-INF/includes/footer.jsp" %>