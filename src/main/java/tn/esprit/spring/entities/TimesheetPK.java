package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimesheetPK implements Serializable {

	private static final long serialVersionUID = 5377539445871317492L;

	private int idMission;
	
	private int idEmploye;
	
	//Choisir le TemporalType selon le besoin metier
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	

	public TimesheetPK() {
		super();
	}
	
	public TimesheetPK(int idMission, int idEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idMission = idMission;
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	//Pour que hibernate peut comparer deux objets (par exemple : recherche de l'objet dans le persistenceContext), 
	//Il doit pouvoir comparer les primary key des deux entites
	//Vu que l'entite a une clé composé, on doit implementer la methode equal.
	//Utiliser l'IDE pour générer le equal et le hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + idEmploye;
		result = prime * result + idMission;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		TimesheetPK other = (TimesheetPK) obj;
		return idMission == other.idMission &&
				idEmploye == other.idEmploye &&
				(dateDebut != null ? dateDebut.equals(other.dateDebut) : other.dateDebut == null) &&
				(dateFin != null ? dateFin.equals(other.dateFin) : other.dateFin == null);
	}


	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdMission() {
		return idMission;
	}

}
