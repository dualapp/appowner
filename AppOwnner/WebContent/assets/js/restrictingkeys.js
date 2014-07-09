	function stroke(event) {
		if (event.keyCode > 52 || event.keyCode < 42 )
			{
			 if(event.keyCode!=9 &&  event.keyCode!=8)
				{event.preventDefault();return false;}
			}
}