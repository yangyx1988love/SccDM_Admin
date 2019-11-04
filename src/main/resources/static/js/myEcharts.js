/*
    地图
 */
function intiMap(myChart,seriesName,geoCoordMap,data,center,zoom,symbolSize,symbolSizeAdd) {
    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;
    };
    var top=convertData(data.sort(function (a, b) {
        return b.value - a.value;
    }).slice(0, 1));
    var max=0;
    for(var key in top[0]){
        max=top[0][key][2];
    };
    function renderItem(params, api) {
        var coords = [
            [116.7,39.53],
            [103.73,36.03],
            [112.91,27.87],
            [120.65,28.01],
            [119.57,39.95]
        ];
        var points = [];
        for (var i = 0; i < coords.length; i++) {
            points.push(api.coord(coords[i]));
        }
        var color = api.visual('#fdfdfd');

        return {
            type: 'polygon',
            shape: {
                points: echarts.graphic.clipPointsByRect(points, {
                    x: params.coordSys.x,
                    y: params.coordSys.y,
                    width: params.coordSys.width,
                    height: params.coordSys.height
                })
            },
            style: api.style({
                fill: color,
                stroke: echarts.color.lift(color)
            })
        };
    }
    option = {
        title: {
            text: '',
            subtext: '',
            sublink: '',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
               // var value = (params.value + '').split('.');
               // value = value[0].replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))/g, '$1,') + '.' + value[1];
                return params.seriesName + '<br/>' + params.name + ' : ' + params.value[2];
            }
        },
        bmap: {
            center: center,
            zoom: zoom,
            roam: true,
            mapStyle: {
                styleJson: [{
                    'featureType': 'water',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#4e9ad1'
                    }
                }, {
                    'featureType': 'land',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#f3f3f3'
                    }
                }, {
                    'featureType': 'railway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#82edbc'
                    }
                }, {
                    'featureType': 'highway',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'geometry.fill',
                    'stylers': {
                        'color': '#fefefe'
                    }
                }, {
                    'featureType': 'poi',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'green',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'subway',
                    'elementType': 'all',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'manmade',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'local',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#d1d1d1'
                    }
                }, {
                    'featureType': 'arterial',
                    'elementType': 'labels',
                    'stylers': {
                        'visibility': 'off'
                    }
                }, {
                    'featureType': 'boundary',
                    'elementType': 'all',
                    'stylers': {
                        'color': '#fefefe'
                    }
                },  {
                    'featureType': 'label',
                    'elementType': 'labels.text.fill',
                    'stylers': {
                        'color': 'rgba(0,0,0,0)'
                    }
                }]
            }
        },
        series : [
            {
                name: seriesName,
                type: 'scatter',
                coordinateSystem: 'bmap',
                data: convertData(data),
                symbolSize: function (val) {
                    return (val[2] / max)*symbolSize + symbolSizeAdd;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'red'
                    }
                }
            },
            {
                name: 'Top 5',
                type: 'effectScatter',
                coordinateSystem: 'bmap',
                data: convertData(data.sort(function (a, b) {
                    return b.value - a.value;
                }).slice(0, 6)),
                symbolSize: function (val) {
                    return (val[2] / max)*symbolSize + symbolSizeAdd;
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'red',
                        shadowBlur: 10,
                        shadowColor: '#342930'
                    }
                },
                zlevel: 1
            },
            {
                type: 'custom',
                coordinateSystem: 'bmap',
                renderItem: renderItem,
                itemStyle: {
                    normal: {
                        opacity: 0.5
                    }
                },
                animation: false,
                silent: true,
                data: [0],
                z: -10
            }
        ]
    };
    myChart.setOption(option);
    var bmap = myChart.getModel().getComponent('bmap').getBMap();
    bmap.addControl(new BMap.MapTypeControl());
    bmap.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
    bmap.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
    bmap.enableContinuousZoom();                              //启用地图惯性拖拽，默认禁用
    bmap.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
    bmap.enableScrollWheelZoom();                            //启用滚轮放大缩小
    bmap.addControl(new BMap.MapTypeControl());          //添加地图类型控件
    bmap.setMapStyle({style:'normal'});

    var ctrl = new BMapLib.TrafficControl({
        showPanel: false
    });
    bmap.addControl(ctrl);
    ctrl.setAnchor(BMAP_ANCHOR_BOTTOM_RIGHT);
    ctrl.showTraffic();
}
function initPie(myChart,title,legendData,seriesName,seriesData) {
    option = {
        title : {
            text: title,
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: legendData
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: seriesName,
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:seriesData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}
function inintBarGraph(myChart,title,xAxisData,seriesData) {
    option = {
        title : {
            text: title,
            subtext: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        toolbox: {
            show : true,
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        grid: { // 控制图的大小，调整下面这些值就可以，
            x: 100,//控制x轴文字与底部的距离
            y2: 200 // y2可以控制倾斜的文字狱最右边的距离，放置倾斜的文字超过显示区域
        },
        xAxis : [
            {
                type : 'category',
                data : xAxisData,
                axisLabel: {
                    interval: 0,    //强制文字产生间隔
                    rotate: 45,     //文字逆时针旋转45°
                    textStyle: {    //文字样式
                        color: "black",
                        fontSize: 10,
                        fontFamily: 'Microsoft YaHei'
                    }
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                type:'bar',
                data:seriesData,
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            }
        ]
    };
    myChart.setOption(option);
}
function initFlare(myChart,title,seriesData) {
    myChart.setOption(option = {
        title : {
            text: title,
            subtext: '',
            x:'center'
        },
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series:[
            {
                type: 'tree',
                data: seriesData,

                top: '5%',
                left: '7%',
                bottom: '2%',
                right: '30%',
                symbolSize: 7,
                label: {
                    normal: {
                        position: 'left',
                        verticalAlign: 'middle',
                        align: 'right'
                    }
                },
                leaves: {
                    label: {
                        normal: {
                            position: 'right',
                            verticalAlign: 'middle',
                            align: 'left'
                        }
                    }
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750
            }
        ]
    });
}
function initBarPie(myChart,barJson,barTitle,upPieJson,upPieTitle,downPieJson,downPieTitle) {
    var canvas = document.createElement('canvas');
    var ctx = canvas.getContext('2d');
    canvas.width = canvas.height = 100;
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    ctx.globalAlpha = 0.08;
    ctx.font = '20px Microsoft Yahei';
    ctx.translate(50, 50);
    ctx.rotate(-Math.PI / 4);

    option = {
        backgroundColor: {
            type: 'pattern',
            image: canvas,
            repeat: 'repeat'
        },
        tooltip : {
            formatter: "{b} : {c} ({d}%)"
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        title: [{
            text:barTitle,
            subtext: '',
            x: '25%',
            textAlign: 'center'
        }, {
            text: upPieTitle,
            subtext: '总计 ' + Object.keys(upPieJson).reduce(function (all, key) {
                return all + upPieJson[key];
            }, 0),
            x: '75%',
            textAlign: 'center'
        }, {
            text: downPieTitle,
            subtext: '总计 ' + Object.keys(downPieJson).reduce(function (all, key) {
                return all + downPieJson[key];
            }, 0),
            x: '75%',
            y: '50%',
            textAlign: 'center'
        }],
        grid: [{
            top: 50,
            width: '50%',
            bottom: '45%',
            left: 10,
            containLabel: true
        }, {
            top: '55%',
            width: '50%',
            bottom: 0,
            left: 10,
            containLabel: true
        }],
        xAxis: [{
            type: 'value',
            max: barJson.all,
            splitLine: {
                show: false
            }
        }, {
            type: 'value',
            max: barJson.all,
            gridIndex: 1,
            splitLine: {
                show: false
            }
        }],
        yAxis: [{
            type: 'category',
            data: Object.keys(barJson.upBars),
            axisLabel: {
                interval: 0,
                rotate: 30
            },
            splitLine: {
                show: false
            }
        }, {
            gridIndex: 1,
            type: 'category',
            data: Object.keys(barJson.downBars),
            axisLabel: {
                interval: 0,
                rotate: 30
            },
            splitLine: {
                show: false
            }
        }],
        series: [{
            type: 'bar',
            stack: 'chart',
            z: 3,
            label: {
                normal: {
                    position: 'right',
                    show: true
                }
            },
            data: Object.keys(barJson.upBars).map(function (key) {
                return barJson.upBars[key];
            })
        }, {
            type: 'bar',
            stack: 'chart',
            silent: true,
            itemStyle: {
                normal: {
                    color: '#eee'
                }
            },
            data: Object.keys(barJson.upBars).map(function (key) {
                return barJson.all - barJson.upBars[key];
            })
        }, {
            type: 'bar',
            stack: 'component',
            xAxisIndex: 1,
            yAxisIndex: 1,
            z: 3,
            label: {
                normal: {
                    position: 'right',
                    show: true
                }
            },
            data: Object.keys(barJson.downBars).map(function (key) {
                return barJson.downBars[key];
            })
        }, {
            type: 'bar',
            stack: 'component',
            silent: true,
            xAxisIndex: 1,
            yAxisIndex: 1,
            itemStyle: {
                normal: {
                    color: '#eee'
                }
            },
            data: Object.keys(barJson.downBars).map(function (key) {
                return barJson.all - barJson.downBars[key];
            })
        }, {
            type: 'pie',
            radius: [0, '30%'],
            center: ['75%', '25%'],
            data: Object.keys(upPieJson).map(function (key) {
                return {
                    name: key.replace('.js', ''),
                    value: upPieJson[key]
                }
            })
        }, {
            type: 'pie',
            radius: [0, '30%'],
            center: ['75%', '75%'],
            data: Object.keys(downPieJson).map(function (key) {
                return {
                    name: key.replace('.js', ''),
                    value: downPieJson[key]
                }
            })
        }]
    }
    myChart.setOption(option);
}
function initPieRadar(myChart,legendData,radarIndicator,radarSeriesData,pieSeriesData,pieTitle,radarTitle) {
    option = {
        title:  [{
            text: pieTitle,
            subtext: '',
            x: '25%',
            y: '75%',
            textAlign: 'center'
        }, {
            text:radarTitle ,
            subtext:'',
            x: '75%',
            y: '75%',
            textAlign: 'center'
        }],
        tooltip: {},
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        legend: {
            data: legendData
        },
        radar: [
            {
                indicator: radarIndicator,
                center: ['75%', '50%'],
                radius : '50%',
                startAngle: 90,
                splitNumber: 4,
                // shape: 'circle',
                name: {
                    formatter:'【{value}】',
                    textStyle: {
                        color:'#72ACD1'
                    }
                },
                splitArea: {
                    areaStyle: {
                        color: ['rgba(114, 172, 209, 0.2)',
                            'rgba(114, 172, 209, 0.4)', 'rgba(114, 172, 209, 0.6)',
                            'rgba(114, 172, 209, 0.8)', 'rgba(114, 172, 209, 1)'],
                        shadowColor: 'rgba(0, 0, 0, 0.3)',
                        shadowBlur: 10
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255, 255, 255, 0.5)'
                    }
                },
                splitLine: {
                    lineStyle: {
                        color: 'rgba(255, 255, 255, 0.5)'
                    }
                }
            }
        ],
        series: [
            {
                name: '',
                type: 'radar',
                label: {
                    normal: {
                        show: true,
                        formatter:function(params) {
                            return params.value;
                        }
                    }
                },
                itemStyle: {
                    emphasis: {
                        lineStyle: {
                            width: 4
                        }
                    }
                },
                data: radarSeriesData
            },
            {
                name: '',
                type: 'pie',
                radius : '50%',
                center: ['25%', '50%'],
                data:pieSeriesData,
                label: {
                    normal: {
                        formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                        backgroundColor: '#eee',
                        borderColor: '#aaa',
                        borderWidth: 1,
                        borderRadius: 4,
                        rich: {
                            a: {
                                color: '#999',
                                lineHeight: 22,
                                align: 'center'
                            },

                            hr: {
                                borderColor: '#aaa',
                                width: '100%',
                                borderWidth: 0.5,
                                height: 0
                            },
                            b: {
                                fontSize: 16,
                                lineHeight: 33
                            },
                            per: {
                                color: '#eee',
                                backgroundColor: '#334455',
                                padding: [2, 4],
                                borderRadius: 2
                            }
                        }
                    }
                },
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    }
    myChart.setOption(option);
}
//桑基图
function initSunburst(myChart,seriesData,title) {
    option = {
        title : {
            text: title,
            x:'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{b}: {c} ({d}%)"
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series: {
            type: 'sunburst',
            data: seriesData,
            radius: [0, '80%'],
            label: {
                rotate: 'radial',
                formatter: '{b}:{c} ',
            }
        }
    };
    myChart.setOption(option);
}
//堆叠区域图
function initStackArea(myChart,title,legendData,xAxisData,seriesData) {
    option = {
        title: {
            text: title
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:legendData
        },
        toolbox: {
            show : true,
            right: '2%',
            feature : {
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : xAxisData
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : seriesData
    };
    myChart.setOption(option);
}