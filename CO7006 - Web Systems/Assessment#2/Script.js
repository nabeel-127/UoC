// Inititialisation

// Setup
document.addEventListener('DOMContentLoaded', () => {
	postcodeDropdown1 = document.getElementById('postcodeDropdown1');
	postcodeDropdown2 = document.getElementById('postcodeDropdown2');
	loadPostcodes(postcodeDropdown1);
	loadPostcodes(postcodeDropdown2);
});

// Variable initialisation
const postcodeList = [
	{id: 1, postcode: 'CH14BJ', latitude: 53.2167, longitude: -2.9167},
	{id: 2, postcode: 'M139PL', latitude: 54.4808, longitude: -2.2426},
	{id: 3, postcode: 'L693GJ', latitude: 55, longitude: -2.9916}
];
let postcodeDropdown1;
let postcodeDropdown2;

// Fetch postcodes from the backend and render them
function loadPostcodes(postcodeDropdown) {
	if (postcodeDropdown) {
		postcodeList.forEach(pL => {
			let option = document.createElement('option');
			option.value = pL.postcode; // Set the value attribute of the option
			option.textContent = pL.postcode; // Set the visible text content of the option
			postcodeDropdown.appendChild(option); // Append the option to the dropdown
		});
	}
}

function calculateDistance() {
	const selectedPostcode1 = postcodeDropdown1.value;
    const selectedPostcode2 = postcodeDropdown2.value;
	const postcode1 = postcodeList.find(pL => pL.postcode === selectedPostcode1);
    const postcode2 = postcodeList.find(pL => pL.postcode === selectedPostcode2);
	if (postcode1 && postcode2) {
        const distance = haversineDistance(postcode1.latitude, postcode1.longitude, postcode2.latitude, postcode2.longitude);
        alert(`The distance between ${selectedPostcode1} and ${selectedPostcode2} is ${distance.toFixed(2) / 1000} km.`);
    } else {
        alert('Please select valid postcodes from the dropdowns.');
    }
}

// Function to convert degree to radian if needed
function toRadians(degrees) {
	return degrees * (Math.PI / 180);
}

// Haversine formula implementation
function haversineDistance(lat1, lon1, lat2, lon2, earthRadius = 6371000/* in meters */) {

	let Δφ = toRadians(lat2 - lat1);
	let Δλ = toRadians(lon2 - lon1);
	let φ = toRadians(lat1);
	let λ = toRadians(lat2);

	// Haversine formula
	let a = (Math.sin(Δφ / 2) * Math.sin(Δφ / 2)) + 
			(Math.cos(φ) * Math.cos(λ) *
			Math.sin(Δλ / 2) * Math.sin(Δλ / 2));

	let distance = earthRadius * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));

	return distance;
}
