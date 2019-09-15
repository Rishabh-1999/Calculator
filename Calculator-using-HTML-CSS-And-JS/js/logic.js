var box=document.getElementById('display');

// Function to add digits to evaluate
function addtoscreen(x)
{
	box.value+=x;
	if(x=='c')
	{
		box.value='';
	}
	
}

// Function to print output
function answer()
{
	x=box.value;
	x=eval(x);
	box.value=x;
}

// Function to remove last digit from input
function backspace()
{
	var number=box.value;
	var len=number.length-1;
	var newnumber =number.substring(0,len);
	box.value=newnumber;
}

// Function for power function
function power(y)
{
	x=box.value;
	x=Math.pow(x,y);
	box.value=x;
}