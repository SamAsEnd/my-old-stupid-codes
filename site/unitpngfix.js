var clear="images/clear.gif" //path to clear.gif

pngfix = function()
{
	var els=document.getElementsByTagName('*');
	var i_p=/\.png/i;
	var i=els.length;
	while (i-- >0)
	{
		var el=els[i];
		var es=el.style;
		if (el.src&&el.src.match(i_p)&&es.filter=='')
		{
			el.height = el.height;
			el.width = el.width;
			es.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+el.src+"',sizingMethod='crop')";
			el.src = clear;
		}
		else
		{
			var elb=el.currentStyle.backgroundImage;
			if (elb.match(i_p))
			{
				var path=elb.split('"');
				var rep=(el.currentStyle.backgroundRepeat=='no-repeat')?'crop':'scale';
				es.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+path[1]+"',sizingMethod='"+rep+"')";
				es.height=el.clientHeight+'px';es.backgroundImage="none";
			}
		}
		if (el.currentStyle.position!='absolute' && !es.filter && !el.tagName.match(/(body|html|script)/gi)) 
			es.position="relative";
		if (es.filter&&el.currentStyle.position=="relative") 
			es.position="static";
	}
}
window.attachEvent('onload',pngfix);
//           MINE
function Next()
{
	
}
function Prv()
{
	
}
