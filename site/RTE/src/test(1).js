function SamAsEndLoad()
{
	SamAsEnd.document.designMode = 'On';
}
function SamB()
{
	SamAsEnd.document.execCommand('bold',false,null);
}
function SamU()
{
	SamAsEnd.document.execCommand('underline',false,null);
}
function SamI()
{
	SamAsEnd.document.execCommand('italic',false,null);
}
function SamS()
{
	var Size = prompt ('Enter a size 1 - 7','');
	SamAsEnd.document.execCommand('FontSize',false,Size);
}
function SamC()
{
	var Color = prompt ('Define a basic color or \n apply a hexadecimal color','');
	SamAsEnd.document.execCommand('ForeColor',false,Color);
}
function SamHR()
{
	SamAsEnd.document.execCommand('inserthorizontalrule',false,null);
}
function SamUL()
{
	SamAsEnd.document.execCommand('InsertUnorderedList',false,'newUl');
}
function SamOL()
{
	SamAsEnd.document.execCommand('InsertOrderedList',false,'newOl');
}
function SamLink()
{
	var Link = prompt ('Enter the URL for this link','http://');
	SamAsEnd.document.execCommand('CreateLink',false,Link);
}
function SamUnlink()
{
	SamAsEnd.document.execCommand('Unlink',false,null);
}
function SamImage()
{
	var imgSrc = prompt ('Enter the location','');
	if(imgSrc != null)
	{
		SamAsEnd.document.execCommand('insertimage',false,imgSrc);
	}
}
function submit_form()
{
	var Form = document.getElementById('Form');
	Form.elements['SamAsEndTEXT'].value = window.frames['SamAsEnd'].document.body.innerHTML;
	Form.submit();
}