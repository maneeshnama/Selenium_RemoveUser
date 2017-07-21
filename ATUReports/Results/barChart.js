            $(document).ready(function(){
                var s1 = [3,3,5,0,24,0,5,3,2,2];
                var s2 = [0,31,29,0,2,0,7,10,10,9];
                var s3 = [0,0,0,0,0,0,0,0,0,0];

var ticks = [19,20,21,22,23,24,25,26,27,28];    $.jqplot('bar', [s1, s2, s3], {
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
