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
        <!-- TODO: make clear distinction when good/bad sample is chosen by a user -->
        <div class="tab-pane active" id="good">
            <div>
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">Good sample</h3>
                    </div>
                    <div class="panel-body">
                        <form action="<c:url value="${nav.INJECTION_SQL}${nav.GOOD}"/>" method="post" role="form">
                            <div class="form-group">
                                <label for="inputTerrorist">Prism search terrorist by email</label>
                                <input type="text" class="form-control" id="inputTerrorist" name="terrorist" placeholder="Enter name">
                            </div>
                            <button type="submit" name="search" value="search" class="btn btn-default">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane" id="bad">
            <div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bad sample</h3>
                    </div>
                    <div class="panel-body">
                        <form action="<c:url value="${nav.INJECTION_SQL}${nav.BAD}"/>" method="post">
                            <div class="form-group">
                                <label for="inputTerrorist">Prism search terrorist by email</label>
                                <input type="text" class="form-control" id="inputTerrorist" name="terrorist" placeholder="Enter name">
                            </div>
                            <button type="submit" name="search" value="search" class="btn btn-default">Search</button>
                        </form>
                    </div>
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

<%@include file="/WEB-INF/includes/footer.jsp" %>