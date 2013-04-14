<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="Description" content="We are an official group of former, present or future Erasmus students and simply students with good hearts, who want to create a community service aimed at helping other Erasmus students survive in a foreign land.">
    <meta name="Keywords" content="Erasmus Experience, Erasmus, erasmus trip, intership, erasmus intership, students, student">
    <title><g:layoutTitle default="Hub of Erasmus Experience" /></title>

    <link rel="stylesheet" href="${resource(dir:'css', file:'bootstrap.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'bootstrap-responsive.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'style.css')}" />

    <link href="${resource(dir:'images', file:'favicon.png')}" rel="shortcut icon" type="image/x-icon" />

    <style>
    body{
        padding-top: 40px;
        padding-bottom: 50px;
    }

    </style>
    <script type="text/javascript">

        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-38733327-1']);
        _gaq.push(['_trackPageview']);

        (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();

    </script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <g:layoutHead />
</head>

<body onload="${pageProperty(name:'body.onload')}">

<nav>

    <div class="navbar-fixed-top" >
        <div class="navbar-inner">
            <div class="row-fluid">
                <div class="container">

                    <ul class="nav pull-right">
                        <li>
                            <div class="upbar active"></div>
                            <g:link controller="main">
                                Main
                            </g:link>
                        </li>
                    </ul>

                            <g:form method="GET" class="search pull-right" style="width:50%;" url="[controller: 'searchable', action: 'index']">
                                <g:textField name="q" value="${params.q}" />
                                <input type="image" value="Search" src="${resource(dir: 'images', file: 'search-icon.png')}" />
                            </g:form>

                </div>
            </div>
        </div>
    </div>
</nav>

<div id="patronage" >


    <div class="row">

        <div class="span2"  >
            <div class="row  patronage-inner" style=": 230px; background: #fff;">
                <div id="myCarousel2" class="carousel slide">
                    <div class="carousel-inner">
                        <div class="item active">
                            <a href="http://www.agh.edu.pl/en" target="_blank" title="AGH University of Science and Technology"><img src="${resource(dir:'images', file:'agh.png')}" style="width:90px; margin: 0 auto; margin-top: 25px;  border: 0; "/></a>
                        </div>
                        <div class="item">
                            <a href="http://www.krakow.pl/" target="_blank" title="Miasto Kraków"><img src="${resource(dir:'images', file:'stakra.jpg')}" style="width: 130px; margin: 0 auto; margin-top: 60px; border: 0; "/></a>
                        </div>

                    </div>
                </div><!-- /.carousel -->
            </div><!-- end of first row -->


        </div><!-- end of span2 -->

    </div>

</div><!-- end of patronage -->

<g:layoutBody />


<footer class="footer">
    <div class="footer-inner">
        <div class="container">
            <div class="row">
                <div class="span3 copyrights">
                    <span>
                        Hub of Erasmus Experience &copy; 2013
                    </span>
                </div>

                <div class="span2 pull-right social">
                    <span>
                        <a href="http://facebook.com/hubofee" target="_blank"><img src="${resource(dir: 'images', file: 'fb-icon.png')}" /></a>
                        <a href="https://twitter.com/HubofEE" target="_blank"><img src="${resource(dir: 'images', file: 'twitter-icon.png')}"/></a>
                    </span>
                </div>
            </div>

        </div>
    </div>
</footer>
<div id="collaboration">
    <div class="container">
        <div class="row">
            <div class="span2 ourPartners"><p style="line-height: 50px;" class="pull-right"><strong>Our partners:</strong></p> </div>
            <div class="span10">
                <div id="myCarousel" class="carousel slide">
                    <div class="carousel-inner">
                        <div class="item active">
                            <ul>
                                <li> <a href="http://www.agh.edu.pl/en" target="_blank" title="AGH University of Science and Technology"><img src="${resource(dir: 'images', file: 'agh.png')}" style="height: 40px;"/></a></li>
                                <li><a href="http://www.facebook.com/KlubPodJaszczurami?ref=ts&fref=ts" target="_blank"><img src="${resource(dir: 'images/partners', file: 'jaszczur.jpg')}" /></a></li>

                            </ul>
                        </div>


                    </div>


                </div><!-- /.carousel -->
            </div>
        </div>

    </div>
</div>


<script src="${resource(dir:'js', file:'bootstrap.js')}"></script>
<script src="${resource(dir:'js', file:'bootstrap.min.js')}"></script>
<script src="${resource(dir:'js', file:'bootstrap-carousel.js')}"></script>

<script type="text/javascript">
    !function ($) {
        $(function(){
            // carousel demo
            $('#myCarousel').carousel({
                interval: 7000
            })
        });

        $(function(){
            // carousel demo
            $('#myCarousel2').carousel({
                interval: 5000
            })
        })
    }(window.jQuery)



</script>
</body>

</html>