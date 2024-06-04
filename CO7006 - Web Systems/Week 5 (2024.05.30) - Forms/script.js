document.addEventListener("DOMContentLoaded", function() {
	var today = new Date();

	// Calculate the minimum date (e.g., 120 years ago from today)
	var minDate = new Date(today.getFullYear() - 120, today.getMonth(), today.getDate());
	// Format the minimum date as "YYYY-MM-DD"
	var minDateFormatted = minDate.toISOString().split('T')[0];
	// Set the minimum date for the Date of Birth input field
	document.getElementById("DateOfBirth").setAttribute("min", minDateFormatted);

	// Calculate the maximum date (e.g., 100 years ago from today)
	var maxDate = new Date(today.getFullYear() - 10, today.getMonth(), today.getDate());
	// Format the maximum date as "YYYY-MM-DD"
	var maxDateFormatted = maxDate.toISOString().split('T')[0];
	// Set the maximum date for the Date of Birth input field
	document.getElementById("DateOfBirth").setAttribute("max", maxDateFormatted);
});
