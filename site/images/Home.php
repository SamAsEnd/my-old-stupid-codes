<?php
$pussy = $_GET['Sami'];
$Game = $_GET['Game'];
$Head = "
<head>
	<title>Sam As End</title>
	<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=windows-1252\"/>
	<link href=\"data:image/x-icon;base64,AAABAAEAEBAAAAAAAABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4AKSmRADEx5wAxMf8AMTH/ADEx5wApKZEAAAAOAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAF4AKCj/AF5e/wBbW/8AW1v/AFtb/wBbW/8AXl7/ACEh/wAAAF4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGAAAAD/AAAA/wBjY/8AdHT/AHNz/wBzc/8AdXX/AF5e/wAAAP8AAAD/AAAAYgAAAAAAAAAAAAAAAAAAABIAAAD/AAAA/wAAAP8AKSn/AImJ/wCGhv8Ahob/AImJ/wAjI/8AAAD/AAAA/wAAAP8AAAAUAAAAAAAAAAAAAACbAAAA/wAAAP8AAAD/AAAA/wBqav8AnJz/AJyc/wBpaf8AAAD/AAAA/wAAAP8AAAD/AAAAnwAAAAAAAAAAAAAA8wAAAP8AAAD/AAAA/wAAAP8AQ0P/AIGB/wCFhf8APT3/AAAA/wAAAP8AAAD/AAAA/wAAAPcAAAAAAAAAAAAREf8AEBD/AA4O/wAKCv8AAgL/AGxs/wAAAP8AAAD/AG1t/wAAAP8AAAD/AAAA/wAAAP8AAAD/AAAAAAAAAAAAra3/AMjI/wDHx/8Ax8f/AMnJ/wCurv8AAQH/ABIS/wC2tv8Aycn/AMjI/wDHx/8AyMj/AKur/wAAAAIAAAAAAKSk+wDMzP8Aysr/AMrK/wDKyv8Az8//AIWF/wCFhf8Az8//AMrK/wDKyv8Aysr/AMzM/wCkpPsAAAAAAAAAAACQkKcA19f/ANTU/wDU1P8A2Nj/AKam/wAAAP8AAAD/AKys/wDX1/8A1NT/ANTU/wDX1/8Aj4+pAAAAAAAAAAAAAAAgAMrK/wDf3/8A3t7/AN/f/wAsLP8AAAD/AAAA/wA4OP8A4uL/AN7e/wDf3/8Ay8v/AAAAIAAAAAAAAAAAAAAAAAB0dHwA4+P/AO/v/wCYmP8AAAD/AAAA/wAAAP8AAAD/AKWl/wDu7v8A4+P/AHNzfAAAAAAAAAAAAAAAAAAAAAAAAAAAAH5+fgDLy/8ABAT/AAAA/wAAAP8AAAD/AAAA/wAbG/8A1NT/AH19gQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAkAAAAsQAAAP8AAAD/AAAA/wAAAP8AAACxAAAAJgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADgAAAA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA//8AAPgfAADwDwAA4AcAAMADAACAAQAAgAEAAIABAACAAQAAgAEAAIABAADAAwAA4AcAAPAHAAD4HwAA//8AAA==\" rel=\"icon\" type=\"image/x-icon\" />
	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" /><script type=\"text/javascript\" src=\"unitpngfix.js\"></script>
	<script src=\"Scripts/swfobject_modified.js\" type=\"text/javascript\"></script>
	</head>
	";
$Body_Start = "<body>
			
	<div id=\"main_container\">
	  <div class=\"top_leafs\"><img src=\"images/top_leafs.png\"/></div>
	  <div id=\"header\">
		<div class=\"logo\"> <a href=\"/Home.php\">Sam As End</a> </div>
		<div class=\"menu\">
		  <ul>";		  
print $Head;
print $Body_Start;	
if($pussy=='Home')
		print "<li class=\"selected\"><a href=\"/Home.php?Sami=Home\">Home</a></li>";
else	
		print "<li><a href=\"/Home.php?Sami=Home\">Home</a></li>";
if($pussy=='CSED')
		print "<li class=\"selected\"><a href=\"/Home.php?Sami=CSED\">CSED</a></li>";
else	
		print "<li><a href=\"/Home.php?Sami=CSED\">CSED</a></li>";
if($pussy=='Video')
		print "<li class=\"selected\"><a href=\"/Home.php?Sami=Video\">Video</a></li>";
else	
		print ("<li><a href=\"/Home.php?Sami=Video\">Video</a></li>");
if($pussy=='Download')
		print "<li class=\"selected\"><a href=\"/Home.php?Sami=Download\">Download</a></li>";
else	
		print "<li><a href=\"/Home.php?Sami=Download\">Download</a></li>";		
if($pussy=='Game')
		print "<li class=\"selected\"><a href=\"/Home.php?Sami=Game\">Game</a></li>";
else	
		print "<li><a href=\"/Home.php?Sami=Game\">Game</a></li>";
print (" </ul>
		</div>
	  </div>
	  <div id=\"center_content\">
		<div class=\"left_content\">
	");
////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////
if($pussy=='CSED')
{
print ("
<h1>CSED</h1>
      <h2>What is CSED?</h2>
      <p><img src=\"http://en.wikipedia.org/favicon.ico\" border=\"0\" alt=\"Wikipedia\" class=\"left_icon\" /><a href=\"http://en.wikipedia.org/wiki/Computational_Science_and_Engineering\" style=\"color:#855f35; text-decoration:underline; font-size:18px;\">Computational Science and Engineering</a></p>
<p><b>Computational science and engineering (CSE)</b><br>&nbsp;is a relatively new discipline that deals with the development and application of computational models and simulations, often coupled with high-performance computing, to solve complex physical problems arising in engineering analysis and design (computational engineering) as well as natural phenomena (computational science). CSE has been described as the \"third mode of discovery\" (next to theory and experimentation). In many fields, computer simulation is integral and therefore essential to business and research. Computer simulation provides the capability to enter fields that are either inaccessible to traditional experimentation or where carrying out traditional empirical inquiries is prohibitively expensive. CSE should neither be confused with pure computer science, nor with computer engineering, although a wide domain in the former is used in CSE (e.g., certain algorithms, data structures, parallel programming, high performance computing) and some problems in the latter can be modeled and solved with CSE methods (as an application area).</p>
<h1></h1>
      <h1>&nbsp;</h1>
      <h1>What's Computer Engineering?</h1>
      <iframe width=\"560\" height=\"315\" src=\"http://www.youtube.com/embed/1Zt_H7eIPss\" frameborder=\"0\" allowfullscreen></iframe>
");
}
else if ($pussy=='Video')
{
	$vid = $_GET['vid'];
	if($vid==1)
		print ("<iframe width=\"720\" height=\"405\" src=\"http://www.youtube.com/embed/5z25pGEGBM4?rel=0\" frameborder=\"0\" allowfullscreen></iframe>");
	else if($vid==2)
		print ("<iframe width=\"720\" height=\"405\" src=\"http://www.youtube.com/embed/c7tOAGY59uQ?rel=0\" frameborder=\"0\" allowfullscreen></iframe>");
	else if($vid==3)
		print ("<iframe width=\"720\" height=\"405\" src=\"http://www.youtube.com/embed/LW9rITLjKz8?rel=0\" frameborder=\"0\" allowfullscreen></iframe>");
	else if($vid==4)
		print("<iframe width=\"720\" height=\"405\" src=\"http://www.youtube.com/embed/lWA2pjMjpBs?rel=0\" frameborder=\"0\" allowfullscreen></iframe>");
	else
	{
		print ("<iframe width=\"720\" height=\"405\" src=\"http://www.youtube.com/embed/tvy5TGLUls8?rel=0\" frameborder=\"0\" allowfullscreen></iframe>");
		$vid=0;
	}
		$vid++;
		$url="/Home.php?Sami=Video&vid=$vid";
	print ("
	<h1>&nbsp;</h1>
	<center><a href=\"");
	print $url;
	print ("\"><img src=\"Next-icon.png\"></a></center>");
	
}
else if ($pussy=='Download')
{
	


}
else if ($pussy=='Cplusplus')
{
	include 'main.cpp.php';
}
else if ($pussy=='Game')
{
	print ("
		<OBJECT classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" WIDTH=\"720\" HEIGHT=\"500\" id=\"Yourfilename\">
		<PARAM NAME=movie VALUE=\"Games/Biker.swf\"> <PARAM NAME=quality VALUE=high> <PARAM NAME=bgcolor VALUE=#333399> <EMBED src=\"Games/Biker.swf\" quality=high bgcolor=#000000 WIDTH=\"720\" HEIGHT=\"500\" NAME=\"Yourfilename\" TYPE=\"application/x-shockwave-flash\" PLUGINSPAGE=\"http://www.macromedia.com/go/getflashplayer\"></EMBED> </OBJECT> 
	");
}
else
{
        print ("
        <center><object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0\" width=\"728\" height=\"90\">
	<param name=\"movie\" value=\"flash.swf\" />
	<param name=\"quality\" value=\"best\" />
	<param name=\"menu\" value=\"true\" />
	<param name=\"allowScriptAccess\" value=\"sameDomain\" />
	<embed src=\"flash.swf\" quality=\"best\" menu=\"true\" width=\"728\" height=\"90\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" allowScriptAccess=\"sameDomain\" />
	</object>
	</center>
	<h1>&nbsp;</h1>
              <h1>Welcome to my website</h1>
              <p> <img src=\"http://img812.imageshack.us/img812/5817/jvyjhc7on5.jpg\" border=\"0\" alt=\"Sam\" class=\"left_icon\" /> My name is Samson Endale and am 2<sup>nd</sup> year CSED Bahir Dar University student! This is my website, dedicated for all who need help! I am not a pro but i hope you enjoy and get what you where looking for! and please leave a comment, it will help me more than you think.</p>
              <h1>&nbsp;</h1>
			  <a class=\"read_more\" style=\" font-size: 16px;\" href=\"/Home.php?Sami=Cplusplus\">C++ Progect</a> 
			  <h1>&nbsp;</h1>
              ");
	print ("
		<a class=\"read_more\" href=\"#\" style=\" font-size: 24px;\" onclick=\"window.open('http://samasend.comuf.com/send.php','Send Message','height=500,width=800,left=100,top=100,resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no, status=no');\">Send messege</a>
		
	");
}	  
////////////////////////////////////////////////////////////////////////////	  
print "</div>";
	  
	  
////////////////////////////////////////////////////////////////////////////

print ("
    <div class=\"bottom_content\">
      <div class=\"friends_list\">
        <h1>Other links</h1>
        <ul class=\"list\">
          <li><a href=\"http://www.amanuel.site40.net/\">Amanuel Nega</a></li>
          <li><a href=\"https://www.facebook.com/groups/CSED.BDU/\">CSED</a></li>
          <li><a href=\"https://www.facebook.com/groups/300638059991384/\">BDU yibab campus students</a></li>
          <li><a href=\"http://www.bdu.edu.et/\">BDU</a></li>
        </ul>
      </div>
      <div class=\"bottom_right\"></div>
      <div class=\"footer\"> &copy; Sam As End 2012. All Rights Reserved </div>
    </div>
  </div>
</div>
</body>
</html>
");
?>
