            $(document).ready(function(){
                var s1 = [5,3,2,2,0,2,8,5,10,5];
                var s2 = [7,10,10,9,0,12,6,5,0,5];
                var s3 = [0,0,0,0,0,0,0,0,0,0];

var ticks = [25,26,27,28,29,30,31,32,33,34];    $.jqplot('bar', [s1, s2, s3], {
        animate: true,axesDefaults:{min:0,tickInterval: 6},        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"],
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
