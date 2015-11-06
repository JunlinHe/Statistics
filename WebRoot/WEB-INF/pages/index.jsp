<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">
    <title>统计</title>

    <!-- Bootstrap本地服务器css文件 -->
    <link href="/app/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/app/lib/jasny-bootstrap/css/jasny-bootstrap.css">

    <!--<link href="http://www.fuelcdn.com/fuelux/3.7.3/css/fuelux.min.css" rel="stylesheet"/>-->

    <!--bootstrap-table相关样式-->
    <link href="/app/lib/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="/app/lib/bootstrap-table/extensions/editable/bootstrap-editable.css" rel="stylesheet">

    <link href="/app/comment/css/comment.css" rel="stylesheet">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <!--<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/app/lib/jquery.js"></script>
    <!--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>-->

    <!-- Include all compiled plugins (below), or include individual files as needed -->

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/app/lib/bootstrap/js/bootstrap.min.js"></script>
    <!--<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->

    <!--<script type="text/javascript" src="framework/semantic/components/sidebar.js"></script>-->
    <script type="text/javascript" src="/app/lib/jasny-bootstrap/js/jasny-bootstrap.min.js"></script>

    <script type="text/javascript" src="/app/lib/slimscroll/jquery.slimscroll.js"></script>

    <!--bootstrap-tabble-->
    <script type="text/javascript" src="/app/lib/bootstrap-table/bootstrap-table.js"></script>
    <script type="text/javascript" src="/app/lib/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript" src="/app/lib/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
    <script type="text/javascript" src="/app/lib/bootstrap-table/extensions/editable/bootstrap-editable.js"></script>
    <script type="text/javascript" src="/app/lib/bootstrap-table/extensions/export/bootstrap-table-export.js"></script>
    <script type="text/javascript" src="/app/lib/bootstrap-table/extensions/export/tableExport.js"></script>

    <!--<script src="http://www.fuelcdn.com/fuelux/3.7.3/js/fuelux.min.js"></script>-->
    <script type="text/javascript" src="/app/lib/fuelux/js/tree.js"></script>

    <script type="text/javascript" src="/app/comment/js/app.js"></script>

</head>
<body>

<!-- 页头 -->
<nav class="navbar navbar-default navbar-fixed-top sky-custom-nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand sky-icon-link" href="/index">
                <span class="glyphicon glyphicon-cloud"></span>创维云发布
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <!--主栏目tab-->
            <ul class="nav navbar-nav" role="tablist" id="indexTabs">
                <li role="presentation" class="active"><a href="#terminal" aria-controls="terminal" role="tab" data-toggle="tab">终端</a></li>
                <li role="presentation"><a href="#program" aria-controls="program" role="tab" data-toggle="tab">节目</a></li>
                <li role="presentation"><a href="#material" aria-controls="material" role="tab" data-toggle="tab">素材</a></li>
                <li role="presentation"><a href="#system" aria-controls="system" role="tab" data-toggle="tab">系统</a></li>
            </ul>
            <!--用户操作-->
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle sky-icon-link" data-toggle="dropdown" role="button"
                       aria-haspopup="true"
                       aria-expanded="false">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        用户 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" class="sky-icon-link"><span class="glyphicon glyphicon-user"></span> 个人资料</a>
                        </li>
                        <li><a href="#" class="sky-icon-link"><span class="glyphicon glyphicon-envelope"></span> 消息</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#" class="sky-icon-link"><span class="glyphicon glyphicon-log-out"></span> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<!--主页容器-->
<div class="container .container-smooth sky-custom-container">

    <!-- Nav tabs -->
    <div class="tab-content">
        <!--终端tab-->
        <div role="tabpanel" class="tab-pane fade in active" id="terminal">
            <jsp:include page="terminal/terminal.jsp"/>
        </div>
        <!--节目tab-->
        <div role="tabpanel" class="tab-pane fade" id="program"></div>
        <!--素材管理tab-->
        <div role="tabpanel" class="tab-pane fade" id="material"></div>
        <!--系统tab-->
        <div role="tabpanel" class="tab-pane fade" id="system"></div>

    </div>

</div>
<!-- /.container -->

<!--弹出提示模态框-->
<div class="modal fade" id="fadeModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary sky-save">保存</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--弹出确认模态框-->
<div class="modal fade" id="confirmModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">温馨提示</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-default sky-save">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

</body>
</html>
