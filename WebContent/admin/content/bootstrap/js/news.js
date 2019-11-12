/**
 * Xử lý khi click vào button delete
 * 
 * @param newsId 
 * 
 */
function comfirmDeleteAdmin(newsId) {
	if (confirm("Are you sure??????????")) {
		var deleForm = document.createElement("form");
		deleForm.method = "POST";
		deleForm.action = "deletenews.do";
		// Create an input
		var mapInput = document.createElement("input");
		mapInput.type = "hidden";
		mapInput.name = "newsid";
		mapInput.value = newsId;

		// Add the input to the form
		deleForm.appendChild(mapInput);
		deleForm.submit();
	}
}

function comfirmDeleteAu(newsId) {
	if (confirm("Are you sure??????????")) {
		// Lấy form bởi id
		var form = createForm(newsId);
		// Chuyển sang deleteusercontroller
		form.action = "deletenews.at";
		// Method Post
		// submit form
		form.submit();
	}
}

function createForm(newsId) {
	var deleForm = document.createElement("form");
	deleForm.method = "POST";
	// Create an input
	var mapInput = document.createElement("input");
	mapInput.type = "hidden";
	mapInput.name = "newsid";
	mapInput.value = newsId;

	// Add the input to the form
	deleForm.appendChild(mapInput);

	// Add the form to dom
	document.body.appendChild(mapForm);
	return deleForm;
}