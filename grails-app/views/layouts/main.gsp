<!doctype html>

<html>

<head>

	<meta charset="utf-8">
	<meta name="Description" content="We are an official group of former, present or future Erasmus students and simply students with good hearts, who want to create a community service aimed at helping other Erasmus students survive in a foreign land.">
	<meta name="Keywords" content="Erasmus Experience, Erasmus, erasmus trip, intership, erasmus intership, students, student">
	<title>Hub of Erasmus Experience</title>
	<title><g:layoutTitle default="Hub of Erasmus Experience" /></title>
	<link href="${resource(dir:'css', file:'bootstrap.css')}" rel="stylesheet" type="text/css">
	<link href="${resource(dir:'css', file:'bootstrap-responsive.css')}" rel="stylesheet" type="text/css">
	<link href="${resource(dir:'css', file:'style.css')}" rel="stylesheet" type="text/css" />
<%--	<link href="${resource(dir:'css', file:'default.css')}" rel="stylesheet" type="text/css" />--%>
	<link href="${resource(dir:'images', file:'favicon.png')}" rel="shortcut icon" type="image/x-icon" />
	<style>
		body{
			padding-top: 40px;	
			padding-bottom: 50px;
		}
	</style>
    <%--
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
	--%>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<g:layoutHead />
	
</head>
  
<body  onload="${pageProperty(name:'body.onload')}">

<nav>
	<div class="navbar-fixed-top" >
		<div class="navbar-inner">
	        <div class="row-fluid">
	           	<div class="container">
	           	
	            <ul class="nav pull-right">
	                <li>
	                	<div class="upbar active"></div>
	                	<g:link controller="main">Main</g:link>
	                </li>
	            </ul>

                <g:form method="GET" class="search" style="width:50%;" url="[controller: 'searchable', action: 'index']">
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

<!-- end of fixed header navbar -->
<div class="row" style="border-bottom: 1px solid #ddd;">
    <div class="hubofeebg">
        <div class="hubofeebg-inner">
            <div class="container profile">
                <div class="profile_inner span5" style="margin-left: 0px;">

                    <div id="team_profile_0" class="profile_item_active">
                        <div class="row">
                            <div class="span2 logoWrapper" >
                                <img src="${resource(dir:'images', file:'logo.png')}" class="logo" style="border: 0;"/>
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3 ourDescription" style=" margin-left: 10px;" >
                                <p><small>
                                    <br/>
                                    We are an official group of former, present or future Erasmus students and simply students with good hearts, who want to create a community service aimed at helping other Erasmus students survive in a foreign land. We are operating at AGH University of Science and Technology, all of our work is non-profit and our prime aim is to promote good image of our University and the city of Cracow.</small></p>
                                <!-- profile photo and informations -->
                            </div>

                        </div>
                    </div>

                    <div id="team_profile_1" class="profile_item" >
                        <div class="row">
                            <div class="span2 " >
                                <img src="${resource(dir:'images/profile_photos', file:'1.jpg')}" style="margin-left: 0px;" />
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px;" >Aleksander Sadecki</span></strong></p>
                                <p><small>Aleksander is the originator of this project and the President of Erasmus Experience organization. He was one of the participants of ERASMUS internship in summer 2012.</small></p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>

                    <div id="team_profile_2" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile2.jpg')}" style="margin-left: 0px;" />
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3"  >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px;" class="centered">Maciej Sławiński</span></strong></p>
                                <p><small>Maciej is the main architect of this project and the Vice-President of Erasmus Experience organization. He is a student of AGH University

                                of Science and Technology. </small></p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>

                    <div id="team_profile_3" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile3.jpg')}" style="margin-left: 0px;"/>
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px;">Mateusz Okarmus</span></strong></p>
                                <p><small>Mateusz is the chief of devolepers working on this project and Secretary of Erasmus Experience organization.He is a student of AGH

                                University of Science and technology. </small></p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>

                    <div id="team_profile_4" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile4.jpg')}" style="margin-left: 0px;" />
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;" ><strong><span style="font-size: 16px;">Marek Nogacki</span></strong></p>
                                <p><small>Marek is a back-end web developer of our project. He is a Computer Science student at AGH University of Science and Technology.</small>  </p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>
                    <div id="team_profile_5" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile5.jpg')}" style="margin-left: 0px;"/>
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px;">Maciej Prokopiuk</span></strong></p>
                                <p><small>Maciek is studying Computer Science at AGH University of Technology and Science. In the project he is back-end and front-end developer. Personally he likes watching good movies and do sport.</small> </p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>

                    <div id="team_profile_6" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile6.jpg')}" style="margin-left: 0px;" />
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px; ">Robert Skibiński</span></strong></p>
                                <p><small>Working on the project as a back-end developer, so the result of his work you'll never (hopefully!) see. In his free time he's working as a PADI Dive Instructor.</small> </p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>

                    <div id="team_profile_7" class="profile_item ">
                        <div class="row">
                            <div class="span2" >
                                <img src="${resource(dir:'images/profile_photos', file:'profile7.jpg')}" style="margin-left: 0px;" />
                                <!-- profile photo and informations -->
                            </div>
                            <div class="span3" >
                                <p style="margin-top: 5px;"><strong><span style="font-size: 16px;">Katarzyna Łydka</span></strong></p>
                                <p><small>Kasia is a student of Spanish Language and Culture. She loves travelling and meeting new people. In the project she is a Spanish translator.</small>
                                </p>
                                <!-- profile photo and informations -->
                            </div>
                        </div>
                    </div>
                </div>

                <div class="span5 team" style="margin-left: 40px;">
                    <div class="row">
                        <div class="span5">
                            <h3 class="centered">Let us introduce our team! </h3>
                            <span>
                                <hr class="thinhr"/>
                            </span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span5 " style="margin-left: 15px;">
                            <ul class="teamul">
                                <li><a href="#" id="mini_1"><img src="${resource(dir:'images/profile_photos', file:'profile1_mini.jpg')}" /></a></li>
                                <li><a href="#" id="mini_2" ><img src="${resource(dir:'images/profile_photos', file:'profile2_mini.jpg')}" /></a></li>
                                <li><a href="#" id="mini_3"><img src="${resource(dir:'images/profile_photos', file:'profile3_mini.jpg')}" /></a></li>
                                <li><a href="#" id="mini_4" ><img src="${resource(dir:'images/profile_photos', file:'profile4.jpg')}" /></a></li>
                                <li><a href="#" id="mini_5"><img src="${resource(dir:'images/profile_photos', file:'profile5_mini.jpg')}" /></a></li>
                                <li><a href="#" id="mini_6"><img src="${resource(dir:'images/profile_photos', file:'profile6.jpg')}" /></a></li>
                                <li><a href="#" id="mini_7"><img src="${resource(dir:'images/profile_photos', file:'profile7.jpg')}" /></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- end of top row -->

<div class="row">
    <div class="container" >
        <div class="span9 content" >
            <div class="row">
                <div class="span9 content-header">
                    <h2 class="pull-left" >Latest news</h2>
                </div>
            </div>

            <div class="row">
                <div class="span9 newsletter centered">
                    <g:layoutBody />
                </p>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="span9 news mod2">
                <article>
                    <header>
                        <h5>Starting our portal!  &nbsp;&nbsp;<small class="pull-right" style="margin-right: 10px;"> Date: 22-02-2013</small></h5>
                        <hr class="soften"/>

                    </header>
                    <p>
                        Today we started our web page. Although, it doesn't have its functionality yet, you can admire its interface. Last few weeks we have been working really hard to create the best combination of an easy to use interface and a stylish design. Soon we will have the honor to share our completely functional portal with you. It is our biggest dream from almost 8 months to create a web portal which will help you on your Erasmsus trip. You will find there any necessary information on how to find yourself in a foreign city without basic knowledge of it. If you don’t want to miss the starting date, sign up to the newsletter. <br/>
                    </p>
                </article>
            </div>
        </div>
    </div>
    <div class="span2 counter">
        <div class="row">
            <div  class="span2 centered" >

            </div>
            <!-- cos -->
        </div>

    </div>



</div>
</div>
<!-- end of content -->

<div id="partners" class="row">
    <div class="span12">
    </div>
</div>
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
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-carousel.js"></script>
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



    jQuery(document).ready( function() {

        jQuery('.teamul img').hover(
                function() {
                    jQuery(this).css('z-index', 99999);
                    jQuery(this).animate({ 'zoom': 1.15 }, 200);

                },
                function() {
                    jQuery(this).css('z-index', 1);
                    jQuery(this).animate({ 'zoom': 1 }, 200);
                });

        var currentId = 0;
        var highestId = 7
        jQuery('.teamul a').click(function(){
            var tmpId = jQuery(this).attr('id');
            tmpId = tmpId.replace('mini_','');
            if(tmpId > highestId){

                alert('There is no profile with this id.');
            }else{
                jQuery('#team_profile_'+currentId).fadeOut(500, function(){
                    currentId=tmpId;
                    jQuery('#team_profile_'+currentId).fadeIn();

                });
            }
        });



    });

</script>

</body>

</html>