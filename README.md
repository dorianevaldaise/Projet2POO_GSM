# 📡 Projet POO - Réseau GSM

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![POO](https://img.shields.io/badge/POO-2026-blue)
![Statut](https://img.shields.io/badge/Statut-Termin%C3%A9-green)
![Licence](https://img.shields.io/badge/Licence-MIT-lightgrey)

**Simulation de la partie radio d'un réseau GSM en Java**

Projet réalisé dans le cadre du cours de **Programmation Orientée Objet (POO)** - 2026

---

## 📝 Description

Ce projet simule la **partie radio d'un réseau GSM (Global System for Mobile Communications)** . Il modélise les interactions entre les **stations mobiles (MS)** et les **stations de base (BTS)** au sein d'un réseau cellulaire.

### Fonctionnalités

- ✅ Création d'un réseau avec ses caractéristiques (fréquences, débits, délai)
- ✅ Gestion des BTS (ajout, suppression, recherche)
- ✅ Création d'utilisateurs mobiles : **Smartphones** et **Tablettes**
- ✅ Attachement/détachement des utilisateurs aux BTS
- ✅ Gestion de la **saturation des cellules**
- ✅ Appels entre utilisateurs (même BTS ou BTS différentes)
- ✅ Journal des appels reçus par chaque utilisateur
- ✅ Localisation d'un utilisateur dans le réseau
- ✅ Affichage des performances du réseau
- ✅ Gestion des **exceptions personnalisées**

---

## 🏗️ Architecture du projet
ProjetGSM/
├── src/
│ └── reseau/
│ ├── InterfaceMS.java # Interface pour les stations mobiles
│ ├── EtatCelluleException.java # Exception : cellule saturée
│ ├── MSIntrouvableException.java # Exception : utilisateur introuvable
│ ├── MS.java # Classe abstraite : Station Mobile
│ ├── Smartphone.java # Hérite de MS
│ ├── Tablette.java # Hérite de MS
│ ├── BTS.java # Station de base
│ ├── Reseau.java # Réseau GSM
│ └── TestReseau.java # Programme principal de test
├── build/ # Fichiers compilés
├── nbproject/ # Configuration NetBeans
├── manifest.mf # Manifest du projet
└── README.md # Ce fichier

text

---

## 📊 Diagramme de classes
┌─────────────┐
│ InterfaceMS │ (interface)
│ +sAttacher()│
│ +appeler() │
│ +afficher.. │
└──────┬──────┘
│ implements
▼
┌─────────────┐
│ MS │ (abstract)
│ #nom,prenom │
│ #msisdn,imsi│
│ +sAttacher()│
│ +appeler() │
└──┬──────┬───┘
│ │
▼ ▼
┌──────┐ ┌──────┐
│Smart │ │Tabl. │
│phone │ │ette │
└──────┘ └──────┘

┌────────┐ 1 * ┌──────┐ 1 * ┌──────┐
│Reseau │◆─────▶│ BTS │◆─────▶│ MS │
└────────┘ └──────┘ └──────┘

text

---

## 🔧 Concepts POO utilisés

| Concept | Application |
|---------|-------------|
| **Encapsulation** | Attributs privés/protégés, accessibles via getters |
| **Héritage** | `Smartphone` et `Tablette` héritent de `MS` |
| **Classe abstraite** | `MS` avec la méthode abstraite `afficherType()` |
| **Interface** | `InterfaceMS` définit le contrat des stations mobiles |
| **Polymorphisme** | `MS user = new Smartphone(...)` |
| **Exceptions** | `EtatCelluleException`, `MSIntrouvableException` |

---

## 🚀 Exécution

### Prérequis

- **Java JDK 8** ou supérieur
- Un IDE (NetBeans, Eclipse, IntelliJ) ou un terminal

### Avec un IDE

1. Ouvrir le projet dans votre IDE
2. Exécuter `TestReseau.java`

### En ligne de commande

```bash
cd ProjetGSM/src
javac reseau/*.java
java reseau.TestReseau
