async function getIpClient() {
	try {
		const response = await axios.get('https://api.ipify.org?format=json');
		//console.log(response);
		//console.log(response.data);
		//console.log(response.data.ip);
		document.getElementById("ip").setAttribute("value",response.data.ip);
	} catch (error) {
		console.error(error);
	}
}

getIpClient();
