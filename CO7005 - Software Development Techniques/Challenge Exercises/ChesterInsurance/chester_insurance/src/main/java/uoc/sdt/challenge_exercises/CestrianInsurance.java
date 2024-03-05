package uoc.sdt.challenge_exercises;

class ChesterInsurance {
	String vehicle = "";
	int age = 100, points;
	float totalPremium = 0F;

	void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	void under25(boolean age) {
		this.age = (age == true) ? 1 : 100;
	}
	void setPoints(int points) {
		this.points = points;
	}
	boolean pointsIsValid(String numericText) {
		try {
			points = Integer.parseInt(numericText);
			if (points < 0)
				return false;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	float getTotalPremium() {
		totalPremium = 0;
		if (vehicle.equalsIgnoreCase("car")) {
			totalPremium += 305.0;
		} else if (vehicle.equalsIgnoreCase("motorcycle")) {
			totalPremium += 360.0;
		}		
		if (age < 25)
			totalPremium += (float) (totalPremium * 0.3F);
		if (points > 6)
			totalPremium += 100;
		return totalPremium;
	}
}