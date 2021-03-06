<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/app/lib/jqPlot/jquery.jqplot.min.css" />
<link rel="stylesheet" type="text/css" href="/app/system/css/rpt.css" />
<div id="info1"></div>
<div id="barRenderer" class="rpt"></div>
<div id="pieRenderer" class="rpt"></div>
<div id="lineRenderer" class="rpt"></div>

<%--<script type="text/javascript" src="/app/lib/jquery.js"></script>--%>
<script type="text/javascript" src="/app/lib/jqPlot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.barRenderer.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.pointLabels.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.canvasTextRenderer.min.js"></script>
<script type="text/javascript" src="/app/lib/jqPlot/plugins/jqplot.canvasAxisLabelRenderer.min.js"></script>

<script>
    $(document).ready(function(){
        $.post("/userlog/client",function(data){
            console.log(data);
            var dataSet=[],svalue=[], ticks=[];
            if(data.code==1){
                var arr = data.data;
                for(var i = 0; i < arr.length; i++){
                    ticks[i] = arr[i].name;
                    svalue[i] = Number(arr[i].value);
                }

                for(var i = 0; i < arr.length; i++){
                    dataSet[i] = [arr[i].name,Number(arr[i].value)];
                }
            }else
                return false;

            $.jqplot.config.enablePlugins = true;
//                var s1 = [2, 6, 7, 10];
//                var ticks = ['a', 'b', 'c', 'd'];

            //柱状图
            plot1 = $.jqplot('barRenderer', [svalue], {
                // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
                animate: !$.jqplot.use_excanvas,
                title: '终端使用量统计',
                seriesDefaults:{
                    renderer:$.jqplot.BarRenderer,
                    pointLabels: { show: true }
                },
                axes: {
                    xaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        ticks: ticks
                    }
                },
                highlighter: { show: false }
            });

            $('#barRenderer').bind('jqplotDataClick',function (ev, seriesIndex, pointIndex, data) {
                $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
            });


            //饼状图
            plot2 = $.jqplot('pieRenderer', [dataSet], {
                // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
                animate: !$.jqplot.use_excanvas,
                title: '终端使用量饼状图',
//                gridPadding: {top:0, bottom:38, left:0, right:0},
                seriesDefaults:{
                    renderer:$.jqplot.PieRenderer,
                    trendline:{ show:false },
                    rendererOptions: { padding: 8, showDataLabels: true }
                },
                legend:{
                    show:true,
                    placement: 'outside',
                    rendererOptions: {
                        numberRows: 1
                    },
                    location:'s',
                    marginTop: '15px'
                }
            });

            //线状图
            plot3 = $.jqplot('lineRenderer', [svalue], {
                animate: !$.jqplot.use_excanvas,
                title: '终端使用量折线图',
                axesDefaults: {
                    labelRenderer: $.jqplot.CanvasAxisLabelRenderer
                },
                seriesDefaults: {
                    rendererOptions: {
                        smooth: true
                    }
                },
                axes: {
                    xaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        ticks: ticks
                    }
                },
                highlighter: { show: false }
            });
        });



    });

    function getLog(){

    }
</script>
