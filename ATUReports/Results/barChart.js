            $(document).ready(function(){
                var s1 = [0,0,0,0,2,2,3,3,3,3];
                var s2 = [0,0,0,0,1,1,0,0,0,0];
                var s3 = [3,3,3,3,0,0,0,0,0,0];

var ticks = [8,9,10,11,12,13,14,15,16,17];    $.jqplot('bar', [s1, s2, s3], {
        animate: true,axesDefaults:{min:0,tickInterval: 23},        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"],
        stackSeries: false,
        seriesDefaults: {
            renderer: $.jqplot.BarRenderer,
            pointLabels: {show: true}
            , rendererOptions: {barWidth: 12, barMargin: 25, fillToZero: true}
        }
        ,
        grid: {borderColor: '#ffffff', background: '#ffffff',
            borderWidth: 0.5, // pixel width of border around grid.
            shadow: false // draw a shadow for grid.
        }
        ,
        legend: {
            show: true,
            location: 'e',
            placement: 'outside',
            labels: ['Passed', 'Failed', 'Skipped']
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks,
                label: "Run Number"
            }
            ,
            yaxis: {
                label: "TC Number",
                tickOptions: {
                    formatString: "%dtc"
                }
            }
        }
    });
});
