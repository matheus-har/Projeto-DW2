package br.com.doa.facil.model;

public enum ConservationStatus {
		NOVO("Novo"),
		SEMINOVO("Seminovo");

		private String statusConservation;

		private ConservationStatus(String statusConservation) {
			this.statusConservation = statusConservation;
		}

		public String getStatus() {
			return statusConservation;
		}
}
