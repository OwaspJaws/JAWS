<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../includes/header.jsp" %>

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
        <!-- TODO: make clear distinction when good/bad sample is chosen by a user -->
        <div class="tab-pane active" id="good">
            <div>
                <div class="example">
                    <form action="/sql-injection/good-example" method="post">
                        <h3>Prism search terrorist by email</h3>

                        <p>
                            <input type="text" name="terrorist" value=""/>
                            <input type="submit" name="search" value="search"/>
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <div class="tab-pane" id="bad">
            <div>
                <div class="example">
                    <form action="/sql-injection/bad-example" method="post">
                        <h3>Prism search terrorist by email</h3>

                        <p>
                            <input type="text" name="terrorist" value=""/>
                            <input type="submit" name="search" value="search"/>
                        </p>
                    </form>
                </div>
            </div>
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
            https://www.owasp.org/index.php/SQL_Injection‎
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>