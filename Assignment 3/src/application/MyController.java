package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import entitysets.Age;
import entitysets.AgeCustom1;
import entitysets.AgeReign;
import entitysets.AgeWar;
import entitysets.Dynasty;
import entitysets.DynastyCustom1;
import entitysets.Reign;
import entitysets.ReignWar;
import entitysets.Ruler;
import entitysets.RulerCustom1;
import entitysets.RulerCustom2;
import entitysets.War;
import entitysets.WarCustom1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyController implements Initializable {
	// MySQL connector
	Connection connection;

	// Command Buttons
	@FXML
	private Button SearchButtonID;
	@FXML
	private Button AddButtonID;
	@FXML
	private Button UpdateButtonID;
	@FXML
	private Button DeleteButtonID;

	// Edit Tabs
	@FXML
	private Tab EditReignTabID;
	@FXML
	private Tab EditRulerTabID;
	@FXML
	private Tab EditDynastyTabID;
	@FXML
	private Tab EditAgeTabID;
	@FXML
	private Tab EditWarTabID;
	@FXML
	private Tab EditAgeReignTabID;
	@FXML
	private Tab EditAgeWarTabID;
	@FXML
	private Tab EditReignWarTabID;
	@FXML
	private Tab EditStatisticsTabID;

	// Edit Reign Text Fields
	@FXML
	private TextField ReignReignIDTextField;
	@FXML
	private TextField ReignTitleTextField;
	@FXML
	private ComboBox<String> ReignRulerComboBox;
	@FXML
	private TextField ReignNumberTextField;
	@FXML
	private TextField ReignStartTextField;
	@FXML
	private TextField ReignEndTextField;
	@FXML
	private TextField ReignAreaTextField;

	// Edit Ruler Text Fields
	@FXML
	private TextField RulerRulerIDTextField;
	@FXML
	private TextField RulerFirstnameTextField;
	@FXML
	private TextField RulerSecondnameTextField;
	@FXML
	private TextField RulerSurnameTextField;
	@FXML
	private TextField RulerEpithetTextField;
	@FXML
	private TextField RulerNicknameTextField;
	@FXML
	private ComboBox<String> RulerGenderComboBox;
	@FXML
	private ComboBox<String> RulerDynastyComboBox;

	// Edit Dynasty Text Fields
	@FXML
	private TextField DynastyNameTextField;
	@FXML
	private TextField DynastyEthnicityTextField;

	// Edit Age Text Fields
	@FXML
	private TextField AgeAgeTextField;
	@FXML
	private TextField AgeStartTextField;
	@FXML
	private TextField AgeEndTextField;

	// Edit War Text Fields
	@FXML
	private TextField WarWarTextField;
	@FXML
	private TextField WarStartTextField;
	@FXML
	private TextField WarEndTextField;
	@FXML
	private ComboBox<String> WarResultComboBox;
	@FXML
	private TextField WarMainenemyTextField;

	// Edit Age-Reign Text Fields
	@FXML
	private ComboBox<String> AgeReignAgeComboBox;
	@FXML
	private ComboBox<String> AgeReignReignIDComboBox;

	// Edit Age-War Text Fields
	@FXML
	private ComboBox<String> AgeWarAgeComboBox;
	@FXML
	private ComboBox<String> AgeWarWarComboBox;

	// Edit Reign-War Text Fields
	@FXML
	private ComboBox<String> ReignWarReignIDComboBox;
	@FXML
	private ComboBox<String> ReignWarWarComboBox;

	// Result Tabs
	@FXML
	private TabPane TabPaneID = new TabPane();
	@FXML
	private Tab TabReignID;
	@FXML
	private Tab TabRulerID;
	@FXML
	private Tab TabDynastyID;
	@FXML
	private Tab TabAgeID;
	@FXML
	private Tab TabWarID;
	@FXML
	private Tab TabAgeReignID;
	@FXML
	private Tab TabAgeWarID;
	@FXML
	private Tab TabReignWarID;
	@FXML
	private Tab TabStatisticsID;

	// Table Views
	@FXML
	private TableView<Reign> TableViewReign;
	@FXML
	private TableView<Ruler> TableViewRuler;
	@FXML
	private TableView<Dynasty> TableViewDynasty;
	@FXML
	private TableView<Age> TableViewAge;
	@FXML
	private TableView<War> TableViewWar;
	@FXML
	private TableView<AgeReign> TableViewAgeReign;
	@FXML
	private TableView<AgeWar> TableViewAgeWar;
	@FXML
	private TableView<ReignWar> TableViewReignWar;
	@FXML
	private TableView StatisticsView;

	// Table View Columns
	@FXML
	private TableColumn<Reign, Number> ReignColumn_reignID;
	@FXML
	private TableColumn<Reign, String> ReignColumn_title;
	@FXML
	private TableColumn<Reign, Number> ReignColumn_ruler;
	@FXML
	private TableColumn<Reign, String> ReignColumn_number;
	@FXML
	private TableColumn<Reign, Number> ReignColumn_start;
	@FXML
	private TableColumn<Reign, Number> ReignColumn_end;
	@FXML
	private TableColumn<Reign, String> ReignColumn_area;
	@FXML
	private TableColumn<Ruler, Number> RulerColumn_rulerID;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_firstname;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_secondname;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_surname;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_epithet;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_nickname;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_gender;
	@FXML
	private TableColumn<Ruler, String> RulerColumn_dynasty;
	@FXML
	private TableColumn<Dynasty, String> DynastyColumn_name;
	@FXML
	private TableColumn<Dynasty, String> DynastyColumn_ethnicity;
	@FXML
	private TableColumn<Age, String> AgeColumn_age;
	@FXML
	private TableColumn<Age, Number> AgeColumn_start;
	@FXML
	private TableColumn<Age, Number> AgeColumn_end;
	@FXML
	private TableColumn<War, String> WarColumn_war;
	@FXML
	private TableColumn<War, Number> WarColumn_start;
	@FXML
	private TableColumn<War, Number> WarColumn_end;
	@FXML
	private TableColumn<War, String> WarColumn_result;
	@FXML
	private TableColumn<War, String> WarColumn_mainenemy;
	@FXML
	private TableColumn<AgeReign, String> AgeReignColumn_age;
	@FXML
	private TableColumn<AgeReign, Number> AgeReignColumn_reignID;
	@FXML
	private TableColumn<AgeWar, String> AgeWarColumn_age;
	@FXML
	private TableColumn<AgeWar, String> AgeWarColumn_war;
	@FXML
	private TableColumn<ReignWar, Number> ReignWarColumn_reignID;
	@FXML
	private TableColumn<ReignWar, String> ReignWarColumn_war;

	// TableColumn for Statistic queries
	@FXML
	private TableColumn RulerTimeColumn_time;
	@FXML
	private TableColumn RulerVictoryColumn_victories;
	@FXML
	private TableColumn DynastyNumberColumn_number;
	@FXML
	private TableColumn AgeNumberColumn_number;
	@FXML
	private TableColumn WarNumberColumn_number;

	// InfoBoxes
	@FXML
	private Label AlertID;
	@FXML
	private Label InfoAddID;
	@FXML
	private Label InfoDeleteID;

	// Arrays for EditTabs
	ArrayList<String> reignFields = new ArrayList<String>();
	ArrayList<String> rulerFields = new ArrayList<String>();
	ArrayList<String> dynastyFields = new ArrayList<String>();
	ArrayList<String> ageFields = new ArrayList<String>();
	ArrayList<String> warFields = new ArrayList<String>();
	ArrayList<String> ageReignFields = new ArrayList<String>();
	ArrayList<String> ageWarFields = new ArrayList<String>();
	ArrayList<String> reignWarFields = new ArrayList<String>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ReignColumn_reignID.setCellValueFactory(new PropertyValueFactory<Reign, Number>("reignID"));
		ReignColumn_title.setCellValueFactory(new PropertyValueFactory<Reign, String>("title"));
		ReignColumn_ruler.setCellValueFactory(new PropertyValueFactory<Reign, Number>("ruler"));
		ReignColumn_number.setCellValueFactory(new PropertyValueFactory<Reign, String>("number"));
		ReignColumn_start.setCellValueFactory(new PropertyValueFactory<Reign, Number>("start"));
		ReignColumn_end.setCellValueFactory(new PropertyValueFactory<Reign, Number>("end"));
		ReignColumn_area.setCellValueFactory(new PropertyValueFactory<Reign, String>("area"));
		RulerColumn_rulerID.setCellValueFactory(new PropertyValueFactory<Ruler, Number>("rulerID"));
		RulerColumn_firstname.setCellValueFactory(new PropertyValueFactory<Ruler, String>("firstname"));
		RulerColumn_secondname.setCellValueFactory(new PropertyValueFactory<Ruler, String>("secondname"));
		RulerColumn_surname.setCellValueFactory(new PropertyValueFactory<Ruler, String>("surname"));
		RulerColumn_epithet.setCellValueFactory(new PropertyValueFactory<Ruler, String>("epithet"));
		RulerColumn_nickname.setCellValueFactory(new PropertyValueFactory<Ruler, String>("nickname"));
		RulerColumn_gender.setCellValueFactory(new PropertyValueFactory<Ruler, String>("gender"));
		RulerColumn_dynasty.setCellValueFactory(new PropertyValueFactory<Ruler, String>("dynasty"));
		DynastyColumn_name.setCellValueFactory(new PropertyValueFactory<Dynasty, String>("name"));
		DynastyColumn_ethnicity.setCellValueFactory(new PropertyValueFactory<Dynasty, String>("ethnicity"));
		AgeColumn_age.setCellValueFactory(new PropertyValueFactory<Age, String>("age"));
		AgeColumn_start.setCellValueFactory(new PropertyValueFactory<Age, Number>("start"));
		AgeColumn_end.setCellValueFactory(new PropertyValueFactory<Age, Number>("end"));
		WarColumn_war.setCellValueFactory(new PropertyValueFactory<War, String>("war"));
		WarColumn_start.setCellValueFactory(new PropertyValueFactory<War, Number>("start"));
		WarColumn_end.setCellValueFactory(new PropertyValueFactory<War, Number>("end"));
		WarColumn_result.setCellValueFactory(new PropertyValueFactory<War, String>("result"));
		WarColumn_mainenemy.setCellValueFactory(new PropertyValueFactory<War, String>("mainenemy"));
		AgeReignColumn_age.setCellValueFactory(new PropertyValueFactory<AgeReign, String>("age"));
		AgeReignColumn_reignID.setCellValueFactory(new PropertyValueFactory<AgeReign, Number>("reignID"));
		AgeWarColumn_age.setCellValueFactory(new PropertyValueFactory<AgeWar, String>("age"));
		AgeWarColumn_war.setCellValueFactory(new PropertyValueFactory<AgeWar, String>("war"));
		ReignWarColumn_reignID.setCellValueFactory(new PropertyValueFactory<ReignWar, Number>("reignID"));
		ReignWarColumn_war.setCellValueFactory(new PropertyValueFactory<ReignWar, String>("war"));

		// Arrays for edit tabs
		reignFields.add("reignID");
		reignFields.add("title");
		reignFields.add("ruler");
		reignFields.add("number");
		reignFields.add("start");
		reignFields.add("end");
		reignFields.add("area");
		rulerFields.add("rulerID");
		rulerFields.add("firstname");
		rulerFields.add("secondname");
		rulerFields.add("surname");
		rulerFields.add("epithet");
		rulerFields.add("nickname");
		rulerFields.add("gender");
		rulerFields.add("dynasty");
		dynastyFields.add("name");
		dynastyFields.add("ethnicity");
		ageFields.add("age");
		ageFields.add("start");
		ageFields.add("end");
		warFields.add("war");
		warFields.add("start");
		warFields.add("end");
		warFields.add("result");
		warFields.add("mainenemy");
		ageReignFields.add("age");
		ageReignFields.add("reignID");
		ageWarFields.add("age");
		ageWarFields.add("war");
		reignWarFields.add("reignID");
		reignWarFields.add("war");

		// Initialization table
		showTable("reign");

		// Edit Tab ComboBoxes
		updateComboBox();
		RulerGenderComboBox.getItems().add("");
		RulerGenderComboBox.getItems().add("female");
		RulerGenderComboBox.getItems().add("male");
		WarResultComboBox.getItems().add("");
		WarResultComboBox.getItems().add("Victory");
		WarResultComboBox.getItems().add("Draw");
		WarResultComboBox.getItems().add("Defeat");
		WarResultComboBox.getItems().add("DELETE");

		// Result Tabs
		TabReignID.setOnSelectionChanged(e -> showTable("reign"));
		TabRulerID.setOnSelectionChanged(e -> showTable("ruler"));
		TabDynastyID.setOnSelectionChanged(e -> showTable("dynasty"));
		TabAgeID.setOnSelectionChanged(e -> showTable("age"));
		TabWarID.setOnSelectionChanged(e -> showTable("war"));
		TabAgeReignID.setOnSelectionChanged(e -> showTable("ageReign"));
		TabAgeWarID.setOnSelectionChanged(e -> showTable("ageWar"));
		TabReignWarID.setOnSelectionChanged(e -> showTable("reignWar"));
		TabStatisticsID.setOnSelectionChanged(e -> showTable("statistics"));

		// Edit Tabs
		ArrayList<TextField> textfieldArray = new ArrayList<TextField>();
		List<TextField> textfieldList = Arrays.asList(ReignReignIDTextField, ReignTitleTextField, ReignNumberTextField,
				ReignStartTextField, ReignEndTextField, ReignAreaTextField, RulerRulerIDTextField,
				RulerFirstnameTextField, RulerSecondnameTextField, RulerSurnameTextField, RulerEpithetTextField,
				RulerNicknameTextField, DynastyNameTextField, DynastyEthnicityTextField, AgeAgeTextField,
				AgeStartTextField, AgeEndTextField, WarWarTextField, WarStartTextField, WarEndTextField,
				WarMainenemyTextField);
		textfieldArray.addAll(textfieldList);
		for (TextField tf : textfieldArray) {
			tf.setOnKeyReleased(e -> checkButton());
		}
		ArrayList<Tab> edtiTabArray = new ArrayList<Tab>();
		List<Tab> tabList = Arrays.asList(EditReignTabID, EditRulerTabID, EditDynastyTabID, EditAgeTabID, EditWarTabID,
				EditAgeReignTabID, EditAgeWarTabID, EditReignWarTabID);
		edtiTabArray.addAll(tabList);
		for (Tab tab : edtiTabArray) {
			tab.setOnSelectionChanged(e -> checkButton());
		}

		ArrayList<ComboBox> comboBoxArray = new ArrayList<ComboBox>();
		List<ComboBox> comBoList = Arrays.asList(ReignRulerComboBox, RulerGenderComboBox, RulerDynastyComboBox,
				WarResultComboBox, AgeReignAgeComboBox, AgeReignReignIDComboBox, AgeWarAgeComboBox, AgeWarWarComboBox,
				ReignWarReignIDComboBox, ReignWarWarComboBox);
		comboBoxArray.addAll(comBoList);
		for (ComboBox comboBox : comboBoxArray) {
			comboBox.setOnAction(e -> checkButton());
		}

		// Values for InfoBoxes
		AlertID.setTextFill(Color.RED);
		AlertID.setStyle("-fx-alignment: CENTER;");
		AlertID.setFont(new Font("Arial", 18));
		InfoAddID.setTextFill(Color.BLACK);
		InfoAddID.setStyle("-fx-alignment: CENTER;");
		InfoAddID.setFont(new Font("Arial", 18));
		InfoDeleteID.setTextFill(Color.BLACK);
		InfoDeleteID.setStyle("-fx-alignment: CENTER;");
		InfoDeleteID.setFont(new Font("Arial", 18));
		checkButton();
	}

	// Check the user's input to decide whether to disable buttons or not
	public void checkButton() {
		// General variables
		boolean flag = false;
		InfoAddID.setText("");
		InfoDeleteID.setText("");
		AlertID.setText("");
		int index = 0;
		if (EditReignTabID.isSelected()) {
			ArrayList<Integer> rID = getIntegerData("reignID", "reign");
			for (int i = 0; i < rID.size(); i++) {
				if (ReignColumn_reignID.getCellData(i) != null && ReignColumn_reignID.getCellData(i).toString().equals(ReignReignIDTextField.getText())) {
					index = i;
					flag = true;
					break;

				}
			}
			boolean ageReignFlag = false;
			ArrayList<String> ageReign = getStringData("reignID", "age_has_reign");
			for (int i = 0; i < ageReign.size(); i++) {
				if (ageReign.get(i).equalsIgnoreCase(ReignReignIDTextField.getText())) {
					ageReignFlag = true;
					break;
				}
			}
			boolean reignWarFlag = false;
			ArrayList<String> ageWar = getStringData("reignID", "reign_has_war");
			for (int i = 0; i < ageWar.size(); i++) {
				if (ageWar.get(i).equalsIgnoreCase(ReignReignIDTextField.getText())) {
					reignWarFlag = true;
					break;
				}
			}
			if (verifyInt(ReignReignIDTextField.getText()) == false || verifyInt(ReignStartTextField.getText()) == false
					|| verifyInt(ReignEndTextField.getText()) == false
					|| verifyInt(ReignStartTextField.getText()) == true
							&& verifyEmpty(ReignStartTextField.getText()) == true
							&& verifyInt(ReignEndTextField.getText()) == true
							&& verifyEmpty(ReignEndTextField.getText()) == true && Integer.parseInt(
									ReignStartTextField.getText()) > (Integer.parseInt(ReignEndTextField.getText()))) {
				SearchButtonID.setDisable(true);
			} else if (ReignTitleTextField.getText().equals("DELETE") || ReignNumberTextField.getText().equals("DELETE")
					|| ReignAreaTextField.getText().equals("DELETE")) {
				SearchButtonID.setDisable(true);
			} else {
				SearchButtonID.setDisable(false);
			}
			if (!flag || ageReignFlag || reignWarFlag || verifyEmpty(ReignReignIDTextField.getText()) == false
					|| verifyInt(ReignReignIDTextField.getText()) == false
					|| verifyEmpty(ReignTitleTextField.getText()) == true
					|| (ReignRulerComboBox.getValue() != null && !ReignRulerComboBox.getValue().equals(""))
					|| verifyEmpty(ReignNumberTextField.getText()) == true
					|| verifyEmpty(ReignStartTextField.getText()) == true
					|| verifyEmpty(ReignEndTextField.getText()) == true
					|| verifyEmpty(ReignAreaTextField.getText()) == true) {
				DeleteButtonID.setDisable(true);
				if (verifyEmpty(ReignReignIDTextField.getText()) == true
						&& verifyInt(ReignReignIDTextField.getText()) == true) {
					if (!flag) {
						InfoDeleteID.setText("Cannot delete or update since reignID does not exist in table reign");
					} else if (ageReignFlag) {
						InfoDeleteID.setText("Cannot delete since reignID is used in table AgeReign");
					} else if (reignWarFlag) {
						InfoDeleteID.setText("Cannot delete since reignID is used in table ReignWar");
					} else {
						InfoDeleteID.setText("Refer only to key value to delete");
					}
				} else {
					InfoDeleteID.setText("");
				}
			} else {
				DeleteButtonID.setDisable(false);
				InfoDeleteID.setText("");
			}
			if (flag || verifyEmpty(ReignReignIDTextField.getText()) == false
					|| verifyEmpty(ReignTitleTextField.getText()) == false
					|| verifyInt(ReignReignIDTextField.getText()) == false || ReignRulerComboBox.getValue() == null
					|| ReignRulerComboBox.getValue().equals("") || verifyEmpty(ReignStartTextField.getText()) == false
					|| verifyInt(ReignStartTextField.getText()) == false
					|| verifyInt(ReignEndTextField.getText()) == false
					|| verifyEmpty(ReignAreaTextField.getText()) == false) {
				AddButtonID.setDisable(true);
				if (verifyEmpty(ReignReignIDTextField.getText()) == true
						&& verifyInt(ReignReignIDTextField.getText()) == true) {
					if (flag) {
						InfoAddID.setText("Cannot add since reignID already exists in table reign");
					} else {
						InfoAddID.setText("");
					}
				} else {
					InfoAddID.setText("");
				}
			} else if (verifyInt(ReignStartTextField.getText()) == true
					&& verifyEmpty(ReignStartTextField.getText()) == true
					&& verifyInt(ReignEndTextField.getText()) == true
					&& verifyEmpty(ReignEndTextField.getText()) == true && Integer.parseInt(
							ReignStartTextField.getText()) > (Integer.parseInt(ReignEndTextField.getText()))) {
				AddButtonID.setDisable(true);
			} else if (ReignTitleTextField.getText().equals("DELETE") || ReignNumberTextField.getText().equals("DELETE")
					|| ReignAreaTextField.getText().equals("DELETE")) {
				AddButtonID.setDisable(true);
			} else {
				AddButtonID.setDisable(false);
				InfoAddID.setText("");
			}
			if (verifyInt(ReignReignIDTextField.getText()) == false || verifyInt(ReignStartTextField.getText()) == false
					|| (verifyInt(ReignEndTextField.getText()) == false
							&& !ReignEndTextField.getText().equals("DELETE"))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("Non-Digit characters not allowed for reignID, start, end!");
			} else if ((verifyEmpty(ReignStartTextField.getText()) == true
					&& (verifyEmpty(ReignEndTextField.getText()) == true
							&& !ReignEndTextField.getText().equals("DELETE")
							&& (Integer.parseInt(ReignStartTextField.getText()) > (Integer
									.parseInt(ReignEndTextField.getText())) == true)))
					|| (flag && verifyEmpty(ReignStartTextField.getText()) == false
							&& verifyEmpty(ReignEndTextField.getText()) == true
							&& verifyInt(ReignEndTextField.getText()) == true
							&& ((Integer.parseInt(ReignColumn_start.getCellData(index).toString()) > Integer
									.parseInt(ReignEndTextField.getText().toString()))))
					|| (flag && verifyEmpty(ReignStartTextField.getText()) == true
							&& verifyEmpty(ReignEndTextField.getText()) == false
							&& (Integer.parseInt(ReignColumn_end.getCellData(index).toString()) > 0
									&& (Integer.parseInt(ReignColumn_end.getCellData(index).toString()) < Integer
											.parseInt(ReignStartTextField.getText().toString())) == true))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("End of reign cannot be smaller than start of reign!");
			} else if (!flag || verifyEmpty(ReignReignIDTextField.getText()) == false
					|| verifyInt(ReignReignIDTextField.getText()) == false
					|| ReignTitleTextField.getText().equals("DELETE") || ReignAreaTextField.getText().equals("DELETE")
					|| (verifyInt(ReignStartTextField.getText()) == false
							|| (verifyInt(ReignEndTextField.getText()) == false
									&& !ReignEndTextField.getText().equals("DELETE")))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("");
			} else {
				UpdateButtonID.setDisable(false);
				AlertID.setText("");
			}
		}
		if (EditRulerTabID.isSelected()) {
			ArrayList<Integer> rID = getIntegerData("rulerID", "ruler");
			for (int i = 0; i < rID.size(); i++) {
				if (rID.get(i).toString().equals(RulerRulerIDTextField.getText())) {
					flag = true;
					break;
				}
			}
			boolean reignFlag = false;
			ArrayList<Integer> reign = getIntegerData("ruler", "reign");
			for (int i = 0; i < reign.size(); i++) {
				if (reign.get(i).toString().equals(RulerRulerIDTextField.getText())) {
					reignFlag = true;
					break;
				}
			}
			if (verifyInt(RulerRulerIDTextField.getText()) == false) {
				SearchButtonID.setDisable(true);
			} else if (RulerFirstnameTextField.getText().equals("DELETE")
					|| RulerSecondnameTextField.getText().equals("DELETE")
					|| RulerSurnameTextField.getText().equals("DELETE")
					|| RulerEpithetTextField.getText().equals("DELETE")
					|| RulerNicknameTextField.getText().equals("DELETE")) {
				SearchButtonID.setDisable(true);
			} else {
				SearchButtonID.setDisable(false);
			}
			if (!flag || reignFlag || verifyEmpty(RulerRulerIDTextField.getText()) == false
					|| verifyInt(RulerRulerIDTextField.getText()) == false
					|| verifyEmpty(RulerFirstnameTextField.getText()) == true
					|| verifyEmpty(RulerSecondnameTextField.getText()) == true
					|| verifyEmpty(RulerSurnameTextField.getText()) == true
					|| verifyEmpty(RulerEpithetTextField.getText()) == true
					|| verifyEmpty(RulerNicknameTextField.getText()) == true
					|| (RulerGenderComboBox.getValue() != null && !RulerGenderComboBox.getValue().equals(""))
					|| (RulerDynastyComboBox.getValue() != null && !RulerDynastyComboBox.getValue().equals(""))) {
				DeleteButtonID.setDisable(true);
				if (verifyEmpty(RulerRulerIDTextField.getText()) == true
						&& verifyInt(RulerRulerIDTextField.getText()) == true) {
					if (!flag) {
						InfoDeleteID.setText("Cannot delete or update since rulerID does not exist in table ruler");
					} else if (reignFlag) {
						InfoDeleteID.setText("Cannot delete since rulerID is used in table reign");
					} else {
						InfoDeleteID.setText("Refer only to key value to delete");
					}
				} else {
					InfoDeleteID.setText("");
				}
			} else {
				DeleteButtonID.setDisable(false);
				InfoDeleteID.setText("");
			}
			if (flag || verifyEmpty(RulerRulerIDTextField.getText()) == false
					|| verifyInt(RulerRulerIDTextField.getText()) == false
					|| verifyEmpty(RulerFirstnameTextField.getText()) == false || RulerGenderComboBox.getValue() == null
					|| RulerGenderComboBox.getValue().equals("") || RulerDynastyComboBox.getValue() == null
					|| RulerDynastyComboBox.getValue().equals("")) {
				AddButtonID.setDisable(true);
				if (verifyEmpty(RulerRulerIDTextField.getText()) == true
						&& verifyInt(RulerRulerIDTextField.getText()) == true) {
					if (flag) {
						InfoAddID.setText("Cannot add since rulerID already exists in table ruler");
					} else {
						InfoAddID.setText("");
					}
				} else {
					InfoAddID.setText("");
				}
			} else if (RulerFirstnameTextField.getText().equals("DELETE")
					|| RulerSecondnameTextField.getText().equals("DELETE")
					|| RulerSurnameTextField.getText().equals("DELETE")
					|| RulerEpithetTextField.getText().equals("DELETE")
					|| RulerNicknameTextField.getText().equals("DELETE")) {
				AddButtonID.setDisable(true);
			} else {
				AddButtonID.setDisable(false);
				InfoAddID.setText("");
			}
			if (!flag || verifyEmpty(RulerRulerIDTextField.getText()) == false
					|| verifyInt(RulerRulerIDTextField.getText()) == false
					|| RulerFirstnameTextField.getText().equals("DELETE")) {
				UpdateButtonID.setDisable(true);
				if (verifyInt(RulerRulerIDTextField.getText()) == false) {
					AlertID.setText("Non-Digit characters not allowed for rulerID!");
				} else {
					AlertID.setText("");
				}
			} else {
				UpdateButtonID.setDisable(false);
				AlertID.setText("");
			}
		}
		if (EditDynastyTabID.isSelected()) {
			ArrayList<String> name = getStringData("name", "dynasty");
			for (int i = 0; i < name.size(); i++) {
				if (name.get(i).equalsIgnoreCase(DynastyNameTextField.getText())) {
					flag = true;
					break;
				}
			}
			boolean rulerFlag = false;
			ArrayList<String> rID = getStringData("dynasty", "ruler");
			for (int i = 0; i < rID.size(); i++) {
				if (rID.get(i).equalsIgnoreCase(DynastyNameTextField.getText())) {
					rulerFlag = true;
					break;
				}
			}
			if (DynastyNameTextField.getText().equals("DELETE")
					|| DynastyEthnicityTextField.getText().equals("DELETE")) {
				SearchButtonID.setDisable(true);
			} else {
				SearchButtonID.setDisable(false);
			}
			if (!flag || rulerFlag || verifyEmpty(DynastyNameTextField.getText()) == false
					|| verifyEmpty(DynastyEthnicityTextField.getText()) == true) {
				DeleteButtonID.setDisable(true);
				if (verifyEmpty(DynastyNameTextField.getText()) == true) {
					if (!flag) {
						InfoDeleteID.setText("Cannot delete or update since dynasty does not exist in table dynasty");
					} else if (rulerFlag) {
						InfoDeleteID.setText("Cannot delete since dynasty is used in table ruler");
					} else {
						InfoDeleteID.setText("Refer only to key value to delete");
					}
				} else {
					InfoDeleteID.setText("");
				}
			} else {
				DeleteButtonID.setDisable(false);
				InfoDeleteID.setText("");
			}
			if (flag || verifyEmpty(DynastyNameTextField.getText()) == false
					|| (verifyEmpty(DynastyEthnicityTextField.getText()) == false
							|| DynastyEthnicityTextField.getText().equals("DELETE"))) {
				AddButtonID.setDisable(true);
				if (verifyEmpty(DynastyNameTextField.getText()) == true) {
					if (flag) {
						InfoAddID.setText("Cannot add since dynasty already exists in table dynasty");
					} else {
						InfoAddID.setText("");
					}
				} else {
					InfoAddID.setText("");
				}
			} else if (DynastyNameTextField.getText().equals("DELETE")
					|| DynastyEthnicityTextField.getText().equals("DELETE")) {
				SearchButtonID.setDisable(true);
			} else {
				AddButtonID.setDisable(false);
			}
			if (!flag || verifyEmpty(DynastyNameTextField.getText()) == false
					|| (verifyEmpty(DynastyEthnicityTextField.getText()) == false
							|| DynastyEthnicityTextField.getText().equals("DELETE"))) {
				UpdateButtonID.setDisable(true);
			} else {
				UpdateButtonID.setDisable(false);
			}
		} else if (EditAgeTabID.isSelected()) {
			ArrayList<String> age = getStringData("age", "age");
			for (int i = 0; i < age.size(); i++) {
				if (AgeColumn_age.getCellData(i) != null
						&& AgeColumn_age.getCellData(i).toString().equalsIgnoreCase(AgeAgeTextField.getText())) {
					index = i;
					flag = true;
					break;
				}
			}
			boolean ageReignFlag = false;
			ArrayList<String> ageReign = getStringData("age", "age_has_reign");
			for (int i = 0; i < ageReign.size(); i++) {
				if (ageReign.get(i).equalsIgnoreCase(AgeAgeTextField.getText())) {
					ageReignFlag = true;
					break;
				}
			}
			boolean ageWarFlag = false;
			ArrayList<String> ageWar = getStringData("age", "age_has_war");
			for (int i = 0; i < ageWar.size(); i++) {
				if (ageWar.get(i).equalsIgnoreCase(AgeAgeTextField.getText())) {
					ageWarFlag = true;
					break;
				}
			}
			if (verifyInt(AgeStartTextField.getText()) == false || AgeStartTextField.getText().equals("DELETE")
					|| verifyInt(AgeEndTextField.getText()) == false
					|| verifyInt(AgeStartTextField.getText()) == true
							&& verifyEmpty(AgeStartTextField.getText()) == true
							&& verifyInt(AgeEndTextField.getText()) == true
							&& verifyEmpty(AgeEndTextField.getText()) == true && Integer.parseInt(
									AgeStartTextField.getText()) > (Integer.parseInt(AgeEndTextField.getText()))) {
				SearchButtonID.setDisable(true);
			} else {
				SearchButtonID.setDisable(false);
			}
			if (!flag || ageReignFlag || ageWarFlag || verifyEmpty(AgeAgeTextField.getText()) == false
					|| verifyEmpty(AgeStartTextField.getText()) == true
					|| verifyEmpty(AgeEndTextField.getText()) == true) {
				DeleteButtonID.setDisable(true);
				if (verifyEmpty(AgeAgeTextField.getText()) == true) {
					if (!flag) {
						InfoDeleteID.setText("Cannot delete or update since age does not exist in table age");
					} else if (ageReignFlag) {
						InfoDeleteID.setText("Cannot delete since age is used in table AgeReign");
					} else if (ageWarFlag) {
						InfoDeleteID.setText("Cannot delete since age is used in table AgeWar");
					} else {
						InfoDeleteID.setText("Refer only to key value to delete");
					}
				} else {
					InfoDeleteID.setText("");
				}
			} else {
				DeleteButtonID.setDisable(false);
				InfoDeleteID.setText("");
			}
			if (flag || verifyEmpty(AgeAgeTextField.getText()) == false
					|| verifyEmpty(AgeStartTextField.getText()) == false
					|| verifyInt(AgeStartTextField.getText()) == false || verifyInt(AgeEndTextField.getText()) == false
					|| AgeStartTextField.getText().equals("DELETE")) {
				AddButtonID.setDisable(true);
				if (verifyEmpty(AgeAgeTextField.getText()) == true) {
					if (flag) {
						InfoAddID.setText("Cannot add since age already exists in table age");
					} else {
						InfoAddID.setText("");
					}
				} else {
					InfoAddID.setText("");
				}
			} else {
				AddButtonID.setDisable(false);
			}
			if (verifyInt(AgeStartTextField.getText()) == false
					|| (verifyInt(AgeEndTextField.getText()) == false && !AgeEndTextField.getText().equals("DELETE"))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("Non-Digit characters not allowed for reignID, start, end!");
			} else if ((verifyEmpty(AgeStartTextField.getText()) == true
					&& (verifyEmpty(AgeEndTextField.getText()) == true && !AgeEndTextField.getText().equals("DELETE")
							&& (Integer.parseInt(AgeStartTextField.getText()) > (Integer
									.parseInt(AgeEndTextField.getText())) == true)))
					|| (flag && verifyEmpty(AgeStartTextField.getText()) == false
							&& verifyEmpty(AgeEndTextField.getText()) == true
							&& verifyInt(AgeEndTextField.getText()) == true
							&& ((Integer.parseInt(AgeColumn_start.getCellData(index).toString()) > Integer
									.parseInt(AgeEndTextField.getText().toString()))))
					|| (flag && verifyEmpty(AgeStartTextField.getText()) == true
							&& verifyEmpty(AgeEndTextField.getText()) == false
							&& (Integer.parseInt(AgeColumn_end.getCellData(index).toString()) > 0
									&& (Integer.parseInt(AgeColumn_end.getCellData(index).toString()) < Integer
											.parseInt(AgeStartTextField.getText().toString())) == true))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("End of age cannot be smaller than start of age!");
			} else if (!flag || verifyEmpty(AgeAgeTextField.getText()) == false
					|| AgeStartTextField.getText().equals("DELETE")
					|| (verifyInt(AgeEndTextField.getText()) == false && !AgeEndTextField.getText().equals("DELETE"))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("");
			} else {
				UpdateButtonID.setDisable(false);
				AlertID.setText("");
			}
		} else if (EditWarTabID.isSelected()) {
			index = 0;
			ArrayList<String> war = getStringData("war", "war");
			for (int i = 0; i < war.size(); i++) {
				if (WarColumn_war.getCellData(i) != null
						&& WarColumn_war.getCellData(i).toString().equalsIgnoreCase(WarWarTextField.getText())) {
					index = i;
					flag = true;
					break;
				}
			}
			boolean reignWarFlag = false;
			ArrayList<String> reignWar = getStringData("war", "reign_has_war");
			for (int i = 0; i < reignWar.size(); i++) {
				if (reignWar.get(i).equalsIgnoreCase(WarWarTextField.getText())) {
					reignWarFlag = true;
					break;
				}
			}
			boolean ageWarFlag = false;
			ArrayList<String> ageWar = getStringData("war", "age_has_war");
			for (int i = 0; i < ageWar.size(); i++) {
				if (ageWar.get(i).equalsIgnoreCase(WarWarTextField.getText())) {
					ageWarFlag = true;
					break;
				}
			}

			if (verifyInt(WarStartTextField.getText()) == false || verifyInt(WarEndTextField.getText()) == false
					|| verifyInt(WarStartTextField.getText()) == true
							&& verifyEmpty(WarStartTextField.getText()) == true
							&& verifyInt(WarEndTextField.getText()) == true
							&& verifyEmpty(WarEndTextField.getText()) == true && Integer.parseInt(
									WarStartTextField.getText()) > (Integer.parseInt(WarEndTextField.getText()))) {
				SearchButtonID.setDisable(true);
			} else if (WarWarTextField.getText().equals("DELETE") || WarStartTextField.getText().equals("DELETE")
					|| WarEndTextField.getText().equals("DELETE")
					|| (WarResultComboBox.getValue() != null && WarResultComboBox.getValue().equals("DELETE"))
					|| WarMainenemyTextField.getText().equals("DELETE")) {
				SearchButtonID.setDisable(true);
			} else {
				SearchButtonID.setDisable(false);
			}
			if (!flag || reignWarFlag || ageWarFlag || verifyEmpty(WarWarTextField.getText()) == false
					|| verifyEmpty(WarStartTextField.getText()) == true
					|| verifyEmpty(WarEndTextField.getText()) == true
					|| (WarResultComboBox.getValue() != null && !WarResultComboBox.getValue().equals(""))
					|| verifyEmpty(WarMainenemyTextField.getText()) == true) {
				DeleteButtonID.setDisable(true);
				if (verifyEmpty(WarWarTextField.getText()) == true) {
					if (!flag) {
						InfoDeleteID.setText("Cannot delete or update since war does not exist in table war");
					} else if (reignWarFlag) {
						InfoDeleteID.setText("Cannot delete since war is used in table ReignWar");
					} else if (ageWarFlag) {
						InfoDeleteID.setText("Cannot delete since war is used in table AgeWar");
					} else {
						InfoDeleteID.setText("Refer only to key value to delete");
					}
				} else {
					InfoDeleteID.setText("");
				}
			} else {
				DeleteButtonID.setDisable(false);
				InfoDeleteID.setText("");
			}
			if (flag || verifyEmpty(WarWarTextField.getText()) == false
					|| verifyEmpty(WarStartTextField.getText()) == false
					|| verifyInt(WarStartTextField.getText()) == false || verifyInt(WarEndTextField.getText()) == false
					|| (((WarResultComboBox.getValue() == null || WarResultComboBox.getValue().equals(""))
							&& (verifyEmpty(WarEndTextField.getText()) == false)
							&& (verifyEmpty(WarMainenemyTextField.getText()) == false)) == false
							&& (WarResultComboBox.getValue() != null && !WarResultComboBox.getValue().equals("")
									&& !WarResultComboBox.getValue().equals("DELETE")
									&& ((verifyEmpty(WarEndTextField.getText()) == true)
											&& verifyEmpty(WarMainenemyTextField.getText()) == true)) == false)) {
				AddButtonID.setDisable(true);
				if (verifyEmpty(WarWarTextField.getText()) == true) {
					if (flag) {
						InfoAddID.setText("Cannot add since war already exists in table war");
					} else {
						InfoAddID.setText("");
					}
				} else {
					InfoAddID.setText("");
				}
			} else {
				AddButtonID.setDisable(false);
			}
			if (verifyInt(WarStartTextField.getText()) == false
					|| (verifyInt(WarEndTextField.getText()) == false && !WarEndTextField.getText().equals("DELETE"))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("Non-Digit characters not allowed for reignID, start, end!");
			} else if ((verifyEmpty(WarStartTextField.getText()) == true
					&& (verifyEmpty(WarEndTextField.getText()) == true && !WarEndTextField.getText().equals("DELETE")
							&& (Integer.parseInt(WarStartTextField.getText()) > (Integer
									.parseInt(WarEndTextField.getText())) == true)))
					|| (flag && verifyEmpty(WarStartTextField.getText()) == false
							&& verifyEmpty(WarEndTextField.getText()) == true
							&& verifyInt(WarEndTextField.getText()) == true
							&& ((Integer.parseInt(WarColumn_start.getCellData(index).toString()) > Integer
									.parseInt(WarEndTextField.getText().toString()))))
					|| (flag && verifyEmpty(WarStartTextField.getText()) == true
							&& verifyEmpty(WarEndTextField.getText()) == false
							&& (Integer.parseInt(WarColumn_end.getCellData(index).toString()) > 0
									&& (Integer.parseInt(WarColumn_end.getCellData(index).toString()) < Integer
											.parseInt(WarStartTextField.getText().toString())) == true))) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("End of war cannot be smaller than start of war!");
			} else if (!flag || verifyEmpty(WarWarTextField.getText()) == false
					|| (verifyInt(WarStartTextField.getText()) == false)
					|| (verifyInt(WarEndTextField.getText()) == false && !WarEndTextField.getText().equals("DELETE"))
					|| ((((WarResultComboBox.getValue() == null || WarResultComboBox.getValue().equals(""))
							&& (verifyEmpty(WarEndTextField.getText()) == false)
							&& (verifyEmpty(WarMainenemyTextField.getText()) == false)) == false
							&& (WarResultComboBox.getValue() != null && !WarResultComboBox.getValue().equals("")
									&& !WarResultComboBox.getValue().equals("DELETE")
									&& ((verifyEmpty(WarEndTextField.getText()) == true)
											&& verifyEmpty(WarMainenemyTextField.getText()) == true)) == false)
							&& (((WarColumn_end.getCellData(index) == null
									|| WarColumn_end.getCellData(index).toString().equals("0"))
									&& WarColumn_result.getCellData(index) == null
									&& WarColumn_mainenemy.getCellData(index) == null) == true))
					|| (WarEndTextField.getText().equals("DELETE") && WarResultComboBox.getValue() != null
							&& WarResultComboBox.getValue().equals("DELETE")
							&& WarMainenemyTextField.getText().equals("DELETE")) == false
							&& (!WarEndTextField.getText().equals("DELETE")
									&& (WarResultComboBox.getValue() == null
											|| !WarResultComboBox.getValue().equals("DELETE"))
									&& (!WarMainenemyTextField.getText().equals("DELETE"))) == false) {
				UpdateButtonID.setDisable(true);
				AlertID.setText("");
			} else {
				UpdateButtonID.setDisable(false);
				AlertID.setText("");
			}
		} else if (EditReignWarTabID.isSelected()) {
			UpdateButtonID.setDisable(true);
			if (ReignWarReignIDComboBox.getValue() == null || ReignWarReignIDComboBox.getValue().equals("")
					|| ReignWarWarComboBox.getValue() == null || ReignWarWarComboBox.getValue().equals("")) {
				AddButtonID.setDisable(true);
				DeleteButtonID.setDisable(true);
			} else {
				ArrayList<String> reignID = getStringData("reignID", "reign_has_war");
				ArrayList<String> war = getStringData("war", "reign_has_war");
				for (int i = 0; i < reignID.size(); i++) {
					if (reignID.get(i).equalsIgnoreCase(ReignWarReignIDComboBox.getValue().toString())
							&& war.get(i).equalsIgnoreCase(ReignWarWarComboBox.getValue().toString())) {
						flag = true;
						break;
					}
				}
				if (flag) {
					AddButtonID.setDisable(true);
					DeleteButtonID.setDisable(false);
				} else if (!flag) {
					AddButtonID.setDisable(false);
					DeleteButtonID.setDisable(true);
				}

			}
		} else if (EditAgeWarTabID.isSelected()) {
			UpdateButtonID.setDisable(true);
			if (AgeWarAgeComboBox.getValue() == null || AgeWarAgeComboBox.getValue().equals("")
					|| AgeWarWarComboBox.getValue() == null || AgeWarWarComboBox.getValue().equals("")) {
				AddButtonID.setDisable(true);
				DeleteButtonID.setDisable(true);
			} else {
				ArrayList<String> age = getStringData("age", "age_has_war");
				ArrayList<String> war = getStringData("war", "age_has_war");
				for (int i = 0; i < age.size(); i++) {
					if (age.get(i).equalsIgnoreCase(AgeWarAgeComboBox.getValue().toString())
							&& war.get(i).equalsIgnoreCase(AgeWarWarComboBox.getValue().toString())) {
						flag = true;
						break;
					}
				}
				if (flag) {
					AddButtonID.setDisable(true);
					DeleteButtonID.setDisable(false);
				} else if (!flag) {
					AddButtonID.setDisable(false);
					DeleteButtonID.setDisable(true);
				}
			}
		} else if (EditAgeReignTabID.isSelected()) {
			UpdateButtonID.setDisable(true);
			if (AgeReignAgeComboBox.getValue() == null || AgeReignAgeComboBox.getValue().equals("")
					|| AgeReignReignIDComboBox.getValue() == null || AgeReignReignIDComboBox.getValue().equals("")) {
				AddButtonID.setDisable(true);
				DeleteButtonID.setDisable(true);
			} else {
				ArrayList<String> age = getStringData("age", "age_has_reign");
				ArrayList<String> reign = getStringData("reignID", "age_has_reign");
				for (int i = 0; i < age.size(); i++) {
					if (age.get(i).equalsIgnoreCase(AgeReignAgeComboBox.getValue().toString())
							&& reign.get(i).equalsIgnoreCase(AgeReignReignIDComboBox.getValue().toString())) {
						flag = true;
						break;
					}
				}
				if (flag) {
					AddButtonID.setDisable(true);
					DeleteButtonID.setDisable(false);
				} else if (!flag) {
					AddButtonID.setDisable(false);
					DeleteButtonID.setDisable(true);
				}
			}
		}
	}

	// Show result tables
	public void showTable(String tab) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();

			if (tab.equals("reign")) {
				ObservableList<Reign> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.reign");
				while (rs.next()) {
					int reignID = rs.getInt("reignID");
					String title = rs.getString("title");
					int ruler = Integer.parseInt(rs.getString("ruler"));
					String number = rs.getString("number");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					String area = rs.getString("area");
					list.add(new Reign(reignID, title, ruler, number, start, end, area));
				}
				TableViewReign.setItems(list);
			} else if (tab.equals("ruler")) {
				TableViewRuler.getColumns().clear();
				TableViewRuler.getColumns().add(RulerColumn_rulerID);
				TableViewRuler.getColumns().add(RulerColumn_firstname);
				TableViewRuler.getColumns().add(RulerColumn_secondname);
				TableViewRuler.getColumns().add(RulerColumn_surname);
				TableViewRuler.getColumns().add(RulerColumn_epithet);
				TableViewRuler.getColumns().add(RulerColumn_nickname);
				TableViewRuler.getColumns().add(RulerColumn_gender);
				TableViewRuler.getColumns().add(RulerColumn_dynasty);
				ObservableList<Ruler> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.ruler");
				while (rs.next()) {
					int rulerID = rs.getInt("rulerID");
					String firstname = rs.getString("firstname");
					String secondname = rs.getString("secondname");
					String surname = rs.getString("surname");
					String epithet = rs.getString("epithet");
					String nickname = rs.getString("nickname");
					String gender = rs.getString("gender");
					String dynasty = rs.getString("dynasty");
					list.add(new Ruler(rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty));
				}
				TableViewRuler.setItems(list);
			} else if (tab.equals("dynasty")) {
				TableViewDynasty.getColumns().clear();
				TableViewDynasty.getColumns().add(DynastyColumn_name);
				TableViewDynasty.getColumns().add(DynastyColumn_ethnicity);
				ObservableList<Dynasty> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.dynasty");
				while (rs.next()) {
					String name = rs.getString("name");
					String ethnicity = rs.getString("ethnicity");
					list.add(new Dynasty(name, ethnicity));
				}
				TableViewDynasty.setItems(list);
			} else if (tab.equals("age")) {
				TableViewAge.getColumns().clear();
				TableViewAge.getColumns().add(AgeColumn_age);
				TableViewAge.getColumns().add(AgeColumn_start);
				TableViewAge.getColumns().add(AgeColumn_end);
				ObservableList<Age> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.age");
				while (rs.next()) {
					String age = rs.getString("age");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					list.add(new Age(age, start, end));
				}
				TableViewAge.setItems(list);
			} else if (tab.equals("war")) {
				TableViewWar.getColumns().clear();
				TableViewWar.getColumns().add(WarColumn_war);
				TableViewWar.getColumns().add(WarColumn_start);
				TableViewWar.getColumns().add(WarColumn_end);
				TableViewWar.getColumns().add(WarColumn_result);
				TableViewWar.getColumns().add(WarColumn_mainenemy);
				ObservableList<War> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.war");
				while (rs.next()) {
					String war = rs.getString("war");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					String result = rs.getString("result");
					String mainenemy = rs.getString("mainenemy");
					list.add(new War(war, start, end, result, mainenemy));
				}
				TableViewWar.setItems(list);
			} else if (tab.equals("ageReign")) {
				ObservableList<AgeReign> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.age_has_reign");
				while (rs.next()) {
					String age = rs.getString("age");
					int reignID = rs.getInt("reignID");
					list.add(new AgeReign(age, reignID));
				}
				TableViewAgeReign.setItems(list);
			} else if (tab.equals("ageWar")) {
				ObservableList<AgeWar> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.age_has_war");
				while (rs.next()) {
					String age = rs.getString("age");
					String war = rs.getString("war");
					list.add(new AgeWar(age, war));
				}
				TableViewAgeWar.setItems(list);
			} else if (tab.equals("reignWar")) {
				ObservableList<ReignWar> list = FXCollections.observableArrayList();
				ResultSet rs = statement.executeQuery("SELECT * FROM projectdb.reign_has_war");
				while (rs.next()) {
					int reignID = rs.getInt("reignID");
					String war = rs.getString("war");
					list.add(new ReignWar(reignID, war));
				}
				TableViewReignWar.setItems(list);
			}
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// List all ruler and the length of their reigns
	public void createRulerCustom1(ActionEvent event) {
		RulerTimeColumn_time = new TableColumn<RulerCustom1, Number>();
		RulerTimeColumn_time.setText("time");
		RulerTimeColumn_time.setStyle("-fx-alignment: CENTER;");
		RulerTimeColumn_time.setCellValueFactory(new PropertyValueFactory<RulerCustom1, Number>("time"));
		StatisticsView.getColumns().clear();
		StatisticsView.getColumns().add(RulerColumn_rulerID);
		StatisticsView.getColumns().add(RulerColumn_firstname);
		StatisticsView.getColumns().add(RulerColumn_secondname);
		StatisticsView.getColumns().add(RulerColumn_surname);
		StatisticsView.getColumns().add(RulerColumn_epithet);
		StatisticsView.getColumns().add(RulerColumn_nickname);
		StatisticsView.getColumns().add(RulerColumn_gender);
		StatisticsView.getColumns().add(RulerColumn_dynasty);
		StatisticsView.getColumns().add(RulerTimeColumn_time);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			StringBuilder selectRulerCustom1 = new StringBuilder(
					"SELECT rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty, IFNULL(SUM(end-start), YEAR(CURDATE())-start) AS time FROM projectdb.reign"
							+ " INNER JOIN projectdb.ruler ON ruler.rulerID = ruler WHERE area = \"Sverige\" GROUP BY ruler");
			ResultSet rs = statement.executeQuery(selectRulerCustom1.toString());
			ObservableList<RulerCustom1> list = FXCollections.observableArrayList();
			while (rs.next()) {
				int rulerID = rs.getInt("rulerID");
				String firstname = rs.getString("firstname");
				String secondname = rs.getString("secondname");
				String surname = rs.getString("surname");
				String epithet = rs.getString("epithet");
				String nickname = rs.getString("nickname");
				String gender = rs.getString("gender");
				String dynasty = rs.getString("dynasty");
				int time = rs.getInt("time");
				list.add(new RulerCustom1(rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty,
						time));
			}
			StatisticsView.setItems(list);
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// List all rulers and the number of victorious wars they have been involved in
	public void createRulerCustom2(ActionEvent event) {
		RulerVictoryColumn_victories = new TableColumn<RulerCustom2, Number>();
		RulerVictoryColumn_victories.setText("victories");
		RulerVictoryColumn_victories.setStyle("-fx-alignment: CENTER;");
		RulerVictoryColumn_victories.setCellValueFactory(new PropertyValueFactory<RulerCustom2, Number>("victories"));
		StatisticsView.getColumns().clear();
		StatisticsView.getColumns().add(RulerColumn_rulerID);
		StatisticsView.getColumns().add(RulerColumn_firstname);
		StatisticsView.getColumns().add(RulerColumn_secondname);
		StatisticsView.getColumns().add(RulerColumn_surname);
		StatisticsView.getColumns().add(RulerColumn_epithet);
		StatisticsView.getColumns().add(RulerColumn_nickname);
		StatisticsView.getColumns().add(RulerColumn_gender);
		StatisticsView.getColumns().add(RulerColumn_dynasty);
		StatisticsView.getColumns().add(RulerVictoryColumn_victories);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			StringBuilder selecStatistics = new StringBuilder(
					"SELECT rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty, victories FROM projectdb.ruler INNER JOIN"
							+ "(SELECT ruler, COUNT(result) AS victories FROM projectdb.reign INNER JOIN projectdb.reign_has_war ON reign_has_war.reignID = reign.reignID"
							+ " INNER JOIN projectdb.war ON reign_has_war.war = war.war WHERE result = \"victory\" GROUP BY ruler) AS B ON ruler.rulerID = B.ruler");
			ResultSet rs = statement.executeQuery(selecStatistics.toString());
			ObservableList<RulerCustom2> list = FXCollections.observableArrayList();
			while (rs.next()) {
				int rulerID = rs.getInt("rulerID");
				String firstname = rs.getString("firstname");
				String secondname = rs.getString("secondname");
				String surname = rs.getString("surname");
				String epithet = rs.getString("epithet");
				String nickname = rs.getString("nickname");
				String gender = rs.getString("gender");
				String dynasty = rs.getString("dynasty");
				int victories = rs.getInt("victories");
				list.add(new RulerCustom2(rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty,
						victories));
			}
			StatisticsView.setItems(list);
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// List all dynasties and the number of wars they have been involved in
	public void createDynastyCustom1(ActionEvent event) {
		DynastyNumberColumn_number = new TableColumn<DynastyCustom1, Number>();
		DynastyNumberColumn_number.setText("number");
		DynastyNumberColumn_number.setStyle("-fx-alignment: CENTER;");
		DynastyNumberColumn_number.setCellValueFactory(new PropertyValueFactory<DynastyCustom1, Number>("number"));
		StatisticsView.getColumns().clear();
		StatisticsView.getColumns().add(RulerColumn_dynasty);
		StatisticsView.getColumns().add(DynastyNumberColumn_number);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			StringBuilder selectStatistics = new StringBuilder(
					"SELECT dynasty, COUNT(dynasty) AS number FROM" + " (SELECT dynasty, war FROM projectdb.ruler"
							+ " INNER JOIN projectdb.reign ON reign.ruler = ruler.rulerID"
							+ " INNER JOIN projectdb.reign_has_war ON reign.reignID = reign_has_war.reignID"
							+ " GROUP BY dynasty, war) AS A GROUP BY dynasty");
			ResultSet rs = statement.executeQuery(selectStatistics.toString());
			ObservableList<DynastyCustom1> list = FXCollections.observableArrayList();
			while (rs.next()) {
				String dynasty = rs.getString("dynasty");
				int number = rs.getInt("number");
				list.add(new DynastyCustom1(dynasty, number));
			}
			StatisticsView.setItems(list);
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// List all ages and the number of different rulers during every age
	public void createAgeCustom1(ActionEvent event) {
		AgeNumberColumn_number = new TableColumn<AgeCustom1, Number>();
		AgeNumberColumn_number.setText("number");
		AgeNumberColumn_number.setStyle("-fx-alignment: CENTER;");
		AgeNumberColumn_number.setCellValueFactory(new PropertyValueFactory<AgeCustom1, Number>("number"));
		StatisticsView.getColumns().clear();
		StatisticsView.getColumns().add(AgeColumn_age);
		StatisticsView.getColumns().add(AgeNumberColumn_number);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			StringBuilder selectStatistics = new StringBuilder(
					"SELECT age, COUNT(age) AS number FROM (SELECT age, ruler FROM projectdb.age_has_reign"
							+ " INNER JOIN projectdb.reign ON reign.reignID = age_has_reign.reignID"
							+ " GROUP BY age, ruler) AS A GROUP BY age");
			ResultSet rs = statement.executeQuery(selectStatistics.toString());
			ObservableList<AgeCustom1> list = FXCollections.observableArrayList();
			while (rs.next()) {
				String age = rs.getString("age");
				int number = rs.getInt("number");
				list.add(new AgeCustom1(age, number));
			}
			StatisticsView.setItems(list);
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// List the numbers of all combinations of wars and results
	public void createWarCustom1(ActionEvent event) {
		WarNumberColumn_number = new TableColumn<WarCustom1, Number>();
		WarNumberColumn_number.setText("number");
		WarNumberColumn_number.setStyle("-fx-alignment: CENTER;");
		WarNumberColumn_number.setCellValueFactory(new PropertyValueFactory<WarCustom1, Number>("number"));
		StatisticsView.getColumns().clear();
		StatisticsView.getColumns().add(WarColumn_mainenemy);
		StatisticsView.getColumns().add(WarColumn_result);
		StatisticsView.getColumns().add(WarNumberColumn_number);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			StringBuilder selectStatistics = new StringBuilder(
					"SELECT mainenemy, result, COUNT(*) AS number FROM projectdb.war" + " GROUP BY mainenemy, result");
			ResultSet rs = statement.executeQuery(selectStatistics.toString());
			ObservableList<WarCustom1> list = FXCollections.observableArrayList();
			while (rs.next()) {
				String mainenemy = rs.getString("mainenemy");
				String result = rs.getString("result");
				int number = rs.getInt("number");
				list.add(new WarCustom1(mainenemy, result, number));
			}
			StatisticsView.setItems(list);
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// Search queries
	public void searchQuery(ActionEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			if (EditReignTabID.isSelected()) {
				if (ReignRulerComboBox.getValue() != null && ReignRulerComboBox.getValue().equals("")) {
					ReignRulerComboBox.setValue(null);
				}
				StringBuilder selectReign = new StringBuilder("SELECT * FROM projectdb.reign WHERE");
				ArrayList<Object> reignValues = new ArrayList<Object>();
				String reignIDString = ReignReignIDTextField.getText();
				String title = ReignTitleTextField.getText();
				String rulerString = "";
				if (ReignRulerComboBox.getValue() != null) {
					rulerString = ReignRulerComboBox.getValue().toString();
				}
				String startString = ReignStartTextField.getText();
				String endString = ReignEndTextField.getText();
				String number = ReignNumberTextField.getText();
				String area = ReignAreaTextField.getText();
				List<Object> reignList = Arrays.asList(reignIDString, title, rulerString, number, startString,
						endString, area);
				reignValues.addAll(reignList);
				for (int i = 0; i < reignFields.size(); i++) {
					if (reignValues.get(i).toString().length() > 0) {
						selectReign.append(" " + reignFields.get(i) + " = '" + reignValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectReign.substring(0, selectReign.length() - 4));
				ReignReignIDTextField.clear();
				ReignTitleTextField.clear();
				ReignRulerComboBox.setValue(null);
				ReignNumberTextField.clear();
				ReignStartTextField.clear();
				ReignEndTextField.clear();
				ReignAreaTextField.clear();
				ObservableList<Reign> list = FXCollections.observableArrayList();
				while (rs.next()) {
					int reignID = rs.getInt("reignID");
					title = rs.getString("title");
					int ruler = rs.getInt("ruler");
					number = rs.getString("number");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					area = rs.getString("area");
					list.add(new Reign(reignID, title, ruler, number, start, end, area));
				}
				TableViewReign.setItems(list);
			} else if (EditRulerTabID.isSelected()) {
				if (RulerGenderComboBox.getValue() != null && RulerGenderComboBox.getValue().equals("")) {
					RulerGenderComboBox.setValue(null);
				}
				if (RulerDynastyComboBox.getValue() != null && RulerDynastyComboBox.getValue().equals("")) {
					RulerDynastyComboBox.setValue(null);
				}
				StringBuilder selectRuler = new StringBuilder("SELECT * FROM projectdb.ruler WHERE");
				ArrayList<Object> rulerValues = new ArrayList<Object>();
				String rulerIDString = RulerRulerIDTextField.getText();
				String firstname = RulerFirstnameTextField.getText();
				String secondname = RulerSecondnameTextField.getText();
				String surname = RulerSurnameTextField.getText();
				String epithet = RulerEpithetTextField.getText();
				String nickname = RulerNicknameTextField.getText();
				String gender = "";
				if (RulerGenderComboBox.getValue() != null) {
					gender = RulerGenderComboBox.getValue().toString();
				}
				String dynasty = "";
				if (RulerDynastyComboBox.getValue() != null) {
					dynasty = RulerDynastyComboBox.getValue().toString();
				}
				List<Object> rulerList = Arrays.asList(rulerIDString, firstname, secondname, surname, epithet, nickname,
						gender, dynasty);
				rulerValues.addAll(rulerList);
				for (int i = 0; i < rulerFields.size(); i++) {
					if (rulerValues.get(i).toString().length() > 0) {
						selectRuler.append(" " + rulerFields.get(i) + " = '" + rulerValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectRuler.substring(0, selectRuler.length() - 4));
				RulerRulerIDTextField.clear();
				RulerFirstnameTextField.clear();
				RulerSecondnameTextField.clear();
				RulerSurnameTextField.clear();
				RulerEpithetTextField.clear();
				RulerNicknameTextField.clear();
				RulerGenderComboBox.setValue(null);
				RulerDynastyComboBox.setValue(null);
				ObservableList<Ruler> list = FXCollections.observableArrayList();
				while (rs.next()) {
					int rulerID = rs.getInt("rulerID");
					firstname = rs.getString("firstname");
					secondname = rs.getString("secondname");
					surname = rs.getString("surname");
					epithet = rs.getString("epithet");
					nickname = rs.getString("nickname");
					gender = rs.getString("gender");
					dynasty = rs.getString("dynasty");
					list.add(new Ruler(rulerID, firstname, secondname, surname, epithet, nickname, gender, dynasty));
				}
				TableViewRuler.setItems(list);
			} else if (EditDynastyTabID.isSelected()) {
				StringBuilder selectDynasty = new StringBuilder("SELECT * FROM projectdb.dynasty WHERE");
				ArrayList<Object> dynastyValues = new ArrayList<Object>();
				String name = DynastyNameTextField.getText();
				String ethnicity = DynastyEthnicityTextField.getText();
				List<Object> dynastyList = Arrays.asList(name, ethnicity);
				dynastyValues.addAll(dynastyList);
				for (int i = 0; i < dynastyFields.size(); i++) {
					if (dynastyValues.get(i).toString().length() > 0) {
						selectDynasty.append(" " + dynastyFields.get(i) + " = '" + dynastyValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectDynasty.substring(0, selectDynasty.length() - 4));
				DynastyNameTextField.clear();
				DynastyEthnicityTextField.clear();
				ObservableList<Dynasty> list = FXCollections.observableArrayList();
				while (rs.next()) {
					name = rs.getString("name");
					ethnicity = rs.getString("ethnicity");
					list.add(new Dynasty(name, ethnicity));
				}
				TableViewDynasty.setItems(list);
			} else if (EditAgeTabID.isSelected()) {
				StringBuilder selectAge = new StringBuilder("SELECT * FROM projectdb.age WHERE");
				ArrayList<Object> ageValues = new ArrayList<Object>();
				String age = AgeAgeTextField.getText();
				String startString = AgeStartTextField.getText();
				String endString = AgeEndTextField.getText();
				List<Object> ageList = Arrays.asList(age, startString, endString);
				ageValues.addAll(ageList);
				for (int i = 0; i < ageFields.size(); i++) {
					if (ageValues.get(i).toString().length() > 0) {
						selectAge.append(" " + ageFields.get(i) + " = '" + ageValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectAge.substring(0, selectAge.length() - 4));
				AgeAgeTextField.clear();
				AgeStartTextField.clear();
				AgeEndTextField.clear();
				ObservableList<Age> list = FXCollections.observableArrayList();
				while (rs.next()) {
					age = rs.getString("age");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					list.add(new Age(age, start, end));
				}
				TableViewAge.setItems(list);
			} else if (EditWarTabID.isSelected()) {
				if (WarResultComboBox.getValue() != null && WarResultComboBox.getValue().equals("")) {
					WarResultComboBox.setValue(null);
				}
				StringBuilder selectWar = new StringBuilder("SELECT * FROM projectdb.war WHERE");
				ArrayList<Object> warValues = new ArrayList<Object>();
				String war = WarWarTextField.getText();
				String startString = WarStartTextField.getText();
				String endString = WarEndTextField.getText();
				String result = "";
				if (WarResultComboBox.getValue() != null) {
					result = WarResultComboBox.getValue().toString();
				}
				String mainenemy = WarMainenemyTextField.getText();
				List<Object> warList = Arrays.asList(war, startString, endString, result, mainenemy);
				warValues.addAll(warList);
				for (int i = 0; i < warFields.size(); i++) {
					if (warValues.get(i).toString().length() > 0) {
						selectWar.append(" " + warFields.get(i) + " = '" + warValues.get(i) + "' AND");
					}
				}

				ResultSet rs = statement.executeQuery(selectWar.substring(0, selectWar.length() - 4));
				WarWarTextField.clear();
				WarStartTextField.clear();
				WarEndTextField.clear();
				WarResultComboBox.setValue(null);
				WarMainenemyTextField.clear();
				ObservableList<War> list = FXCollections.observableArrayList();
				while (rs.next()) {
					war = rs.getString("war");
					int start = rs.getInt("start");
					int end = rs.getInt("end");
					result = rs.getString("result");
					mainenemy = rs.getString("mainenemy");
					list.add(new War(war, start, end, result, mainenemy));
				}
				TableViewWar.setItems(list);
			} else if (EditAgeReignTabID.isSelected()) {
				if (AgeReignAgeComboBox.getValue() != null && AgeReignAgeComboBox.getValue().equals("")) {
					AgeReignAgeComboBox.setValue(null);
				}
				if (AgeReignReignIDComboBox.getValue() != null && AgeReignReignIDComboBox.getValue().equals("")) {
					AgeReignReignIDComboBox.setValue(null);
				}
				StringBuilder selectAgeReign = new StringBuilder("SELECT * FROM projectdb.age_has_reign WHERE");
				ArrayList<Object> ageReignValues = new ArrayList<Object>();
				String age = "";
				if (AgeReignAgeComboBox.getValue() != null) {
					age = AgeReignAgeComboBox.getValue().toString();
				}
				String reignIDString = "";
				if (AgeReignReignIDComboBox.getValue() != null) {
					reignIDString = AgeReignReignIDComboBox.getValue().toString();
				}
				ageReignValues.add(age);
				ageReignValues.add(reignIDString);
				for (int i = 0; i < ageReignFields.size(); i++) {
					if (ageReignValues.get(i).toString().length() > 0) {
						selectAgeReign.append(" " + ageReignFields.get(i) + " = '" + ageReignValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectAgeReign.substring(0, selectAgeReign.length() - 4));
				AgeReignAgeComboBox.setValue(null);
				AgeReignReignIDComboBox.setValue(null);
				ObservableList<AgeReign> list = FXCollections.observableArrayList();
				while (rs.next()) {
					age = rs.getString("age");
					int reignID = rs.getInt("reignID");
					list.add(new AgeReign(age, reignID));
				}
				TableViewAgeReign.setItems(list);
			} else if (EditAgeWarTabID.isSelected()) {
				if (AgeWarAgeComboBox.getValue() != null && AgeWarAgeComboBox.getValue().equals("")) {
					AgeWarAgeComboBox.setValue(null);
				}
				if (AgeWarWarComboBox.getValue() != null && AgeWarWarComboBox.getValue().equals("")) {
					AgeWarWarComboBox.setValue(null);
				}
				StringBuilder selectAgeWar = new StringBuilder("SELECT * FROM projectdb.age_has_war WHERE");
				ArrayList<Object> ageWarValues = new ArrayList<Object>();
				String age = "";
				if (AgeWarAgeComboBox.getValue() != null) {
					age = AgeWarAgeComboBox.getValue().toString();
				}
				String war = "";
				if (AgeWarWarComboBox.getValue() != null) {
					war = AgeWarWarComboBox.getValue().toString();
				}
				ageWarValues.add(age);
				ageWarValues.add(war);
				for (int i = 0; i < ageWarFields.size(); i++) {
					if (ageWarValues.get(i).toString().length() > 0) {
						selectAgeWar.append(" " + ageWarFields.get(i) + " = '" + ageWarValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectAgeWar.substring(0, selectAgeWar.length() - 4));
				AgeWarAgeComboBox.setValue(null);
				AgeWarWarComboBox.setValue(null);
				ObservableList<AgeWar> list = FXCollections.observableArrayList();
				while (rs.next()) {
					age = rs.getString("age");
					war = rs.getString("war");
					list.add(new AgeWar(age, war));
				}
				TableViewAgeWar.setItems(list);
			} else if (EditReignWarTabID.isSelected()) {
				if (ReignWarReignIDComboBox.getValue() != null && ReignWarReignIDComboBox.getValue().equals("")) {
					ReignWarReignIDComboBox.setValue(null);
				}
				if (ReignWarWarComboBox.getValue() != null && ReignWarWarComboBox.getValue().equals("")) {
					ReignWarWarComboBox.setValue(null);
				}
				StringBuilder selectReignWar = new StringBuilder("SELECT * FROM projectdb.reign_has_war WHERE");
				ArrayList<Object> reignWarValues = new ArrayList<Object>();
				String reignIDString = "";
				if (ReignWarReignIDComboBox.getValue() != null) {
					reignIDString = ReignWarReignIDComboBox.getValue().toString();
				}
				String war = "";
				if (ReignWarWarComboBox.getValue() != null) {
					war = ReignWarWarComboBox.getValue().toString();
				}
				reignWarValues.add(reignIDString);
				reignWarValues.add(war);
				for (int i = 0; i < reignWarFields.size(); i++) {
					if (reignWarValues.get(i).toString().length() > 0) {
						selectReignWar.append(" " + reignWarFields.get(i) + " = '" + reignWarValues.get(i) + "' AND");
					}
				}
				ResultSet rs = statement.executeQuery(selectReignWar.substring(0, selectReignWar.length() - 4));
				ReignWarReignIDComboBox.setValue(null);
				ReignWarWarComboBox.setValue(null);
				ObservableList<ReignWar> list = FXCollections.observableArrayList();
				while (rs.next()) {
					int reignID = rs.getInt("reignID");
					war = rs.getString("war");
					list.add(new ReignWar(reignID, war));
				}
				TableViewReignWar.setItems(list);
			}
			connection.close();
			checkButton();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// Add queries
	public void addQuery(ActionEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			if (EditReignTabID.isSelected()) {
				if (ReignRulerComboBox.getValue() != null && ReignRulerComboBox.getValue().equals("")) {
					ReignRulerComboBox.setValue(null);
				}
				StringBuilder addReignOne = new StringBuilder("INSERT INTO reign (");
				StringBuilder addReignTwo = new StringBuilder("VALUES('");
				ArrayList<Object> reignValues = new ArrayList<Object>();
				int reignID = Integer.parseInt(ReignReignIDTextField.getText());
				String title = ReignTitleTextField.getText();
				int ruler = Integer.parseInt(ReignRulerComboBox.getValue());
				String number = ReignNumberTextField.getText();
				int start = Integer.parseInt(ReignStartTextField.getText());
				String endString = ReignEndTextField.getText();
				String area = ReignAreaTextField.getText();
				List<Object> reignList = Arrays.asList(reignID, title, ruler, number, start, endString, area);
				reignValues.addAll(reignList);
				for (int i = 0; i < reignFields.size(); i++) {
					if (reignValues.get(i).toString().length() > 0) {
						addReignOne.append(reignFields.get(i) + ", ");
						addReignTwo.append(reignValues.get(i) + "', '");
					}
				}
				StringBuilder addReign = new StringBuilder(addReignOne.substring(0, addReignOne.length() - 2));
				addReign.append(") ").append(addReignTwo.substring(0, addReignTwo.length() - 3)).append(")");
				statement.execute(addReign.toString());
				ReignReignIDTextField.clear();
				ReignTitleTextField.clear();
				ReignRulerComboBox.setValue(null);
				ReignNumberTextField.clear();
				ReignStartTextField.clear();
				ReignEndTextField.clear();
				ReignAreaTextField.clear();
				showTable("reign");
			} else if (EditRulerTabID.isSelected()) {
				if (RulerGenderComboBox.getValue() != null && RulerGenderComboBox.getValue().equals("")) {
					RulerGenderComboBox.setValue(null);
				}
				if (RulerDynastyComboBox.getValue() != null && RulerDynastyComboBox.getValue().equals("")) {
					RulerDynastyComboBox.setValue(null);
				}
				StringBuilder addRulerOne = new StringBuilder("INSERT INTO ruler (");
				StringBuilder addRulerTwo = new StringBuilder("VALUES('");
				ArrayList<Object> rulerValues = new ArrayList<Object>();
				int rulerID = Integer.parseInt(RulerRulerIDTextField.getText());
				String firstname = RulerFirstnameTextField.getText();
				String secondname = RulerSecondnameTextField.getText();
				String surname = RulerSurnameTextField.getText();
				String epithet = RulerEpithetTextField.getText();
				String nickname = RulerNicknameTextField.getText();
				String gender = RulerGenderComboBox.getValue().toString();
				String dynasty = RulerDynastyComboBox.getValue().toString();
				List<Object> list = Arrays.asList(rulerID, firstname, secondname, surname, epithet, nickname, gender,
						dynasty);
				rulerValues.addAll(list);
				for (int i = 0; i < rulerFields.size(); i++) {
					if (rulerValues.get(i).toString().length() > 0) {
						addRulerOne.append(rulerFields.get(i) + ", ");
						addRulerTwo.append(rulerValues.get(i) + "', '");
					}
				}
				StringBuilder addRuler = new StringBuilder(addRulerOne.substring(0, addRulerOne.length() - 2));
				addRuler.append(") ").append(addRulerTwo.substring(0, addRulerTwo.length() - 3)).append(")");
				statement.execute(addRuler.toString());
				RulerRulerIDTextField.clear();
				RulerFirstnameTextField.clear();
				RulerSecondnameTextField.clear();
				RulerSurnameTextField.clear();
				RulerEpithetTextField.clear();
				RulerNicknameTextField.clear();
				RulerGenderComboBox.setValue(null);
				RulerDynastyComboBox.setValue(null);
				showTable("ruler");
			} else if (EditDynastyTabID.isSelected()) {
				StringBuilder addDynastyOne = new StringBuilder("INSERT INTO dynasty (");
				StringBuilder addDynastyTwo = new StringBuilder("VALUES('");
				ArrayList<Object> dynastyValues = new ArrayList<Object>();
				String name = DynastyNameTextField.getText();
				String ethnicity = DynastyEthnicityTextField.getText();
				List<Object> dynastyList = Arrays.asList(name, ethnicity);
				dynastyValues.addAll(dynastyList);
				for (int i = 0; i < dynastyFields.size(); i++) {
					if (dynastyValues.get(i).toString().length() > 0) {
						addDynastyOne.append(dynastyFields.get(i) + ", ");
						addDynastyTwo.append(dynastyValues.get(i) + "', '");
					}
				}
				StringBuilder addDynasty = new StringBuilder(addDynastyOne.substring(0, addDynastyOne.length() - 2));
				addDynasty.append(") ").append(addDynastyTwo.substring(0, addDynastyTwo.length() - 3)).append(")");
				statement.execute(addDynasty.toString());
				DynastyNameTextField.clear();
				DynastyEthnicityTextField.clear();
				showTable("dynasty");
			} else if (EditAgeTabID.isSelected()) {
				StringBuilder addAgeOne = new StringBuilder("INSERT INTO age (");
				StringBuilder addAgeTwo = new StringBuilder("VALUES('");
				ArrayList<Object> ageValues = new ArrayList<Object>();
				String age = AgeAgeTextField.getText();
				int start = Integer.parseInt(AgeStartTextField.getText());
				String endString = AgeEndTextField.getText();
				List<Object> ageList = Arrays.asList(age, start, endString);
				ageValues.addAll(ageList);
				for (int i = 0; i < ageFields.size(); i++) {
					if (ageValues.get(i).toString().length() > 0) {
						addAgeOne.append(ageFields.get(i) + ", ");
						addAgeTwo.append(ageValues.get(i) + "', '");
					}
				}
				StringBuilder addAge = new StringBuilder(addAgeOne.substring(0, addAgeOne.length() - 2));
				addAge.append(") ").append(addAgeTwo.substring(0, addAgeTwo.length() - 3)).append(")");
				statement.execute(addAge.toString());
				AgeAgeTextField.clear();
				AgeStartTextField.clear();
				AgeEndTextField.clear();
				showTable("age");
			} else if (EditWarTabID.isSelected()) {
				StringBuilder addWarOne = new StringBuilder("INSERT INTO war (");
				StringBuilder addWarTwo = new StringBuilder("VALUES('");
				ArrayList<Object> warValues = new ArrayList<Object>();
				String war = WarWarTextField.getText();
				int start = Integer.parseInt(WarStartTextField.getText());
				String endString = WarEndTextField.getText();
				String result = null;
				if (WarResultComboBox.getValue() != null && !WarResultComboBox.getValue().equals("")) {
					result = WarResultComboBox.getValue().toString();
				}
				String mainenemy = WarMainenemyTextField.getText();
				List<Object> warList = Arrays.asList(war, start, endString, result, mainenemy);
				warValues.addAll(warList);
				for (int i = 0; i < warFields.size(); i++) {
					if (warValues.get(i) != null && warValues.get(i).toString().length() > 0) {
						addWarOne.append(warFields.get(i) + ", ");
						addWarTwo.append(warValues.get(i) + "', '");
					}
				}
				StringBuilder addWar = new StringBuilder(addWarOne.substring(0, addWarOne.length() - 2));
				addWar.append(") ").append(addWarTwo.substring(0, addWarTwo.length() - 3)).append(")");
				statement.execute(addWar.toString());
				WarWarTextField.clear();
				WarStartTextField.clear();
				WarEndTextField.clear();
				WarResultComboBox.setValue(null);
				WarMainenemyTextField.clear();
				showTable("war");
			} else if (EditAgeReignTabID.isSelected()) {
				if (AgeReignAgeComboBox.getValue() != null && AgeReignAgeComboBox.getValue().equals("")) {
					AgeReignAgeComboBox.setValue(null);
				}
				if (AgeReignReignIDComboBox.getValue() != null && AgeReignReignIDComboBox.getValue().equals("")) {
					AgeReignReignIDComboBox.setValue(null);
				}
				StringBuilder addAgeReign = new StringBuilder("INSERT INTO age_has_reign (age, reignID) VALUES('");
				String age = AgeReignAgeComboBox.getValue();
				int reignID = Integer.parseInt(AgeReignReignIDComboBox.getValue());
				addAgeReign.append(age + "', '" + reignID + "')");
				statement.execute(addAgeReign.toString());
				AgeReignAgeComboBox.setValue(null);
				AgeReignReignIDComboBox.setValue(null);
				showTable("ageReign");
			} else if (EditAgeWarTabID.isSelected()) {
				if (AgeWarAgeComboBox.getValue() != null && AgeWarAgeComboBox.getValue().equals("")) {
					AgeWarAgeComboBox.setValue(null);
				}
				if (AgeWarWarComboBox.getValue() != null && AgeWarWarComboBox.getValue().equals("")) {
					AgeWarWarComboBox.setValue(null);
				}
				StringBuilder addAgeWar = new StringBuilder("INSERT INTO age_has_war (age, war) VALUES('");
				String age = AgeWarAgeComboBox.getValue();
				String war = AgeWarWarComboBox.getValue();
				addAgeWar.append(age + "', '" + war + "')");
				statement.execute(addAgeWar.toString());
				AgeWarAgeComboBox.setValue(null);
				AgeWarWarComboBox.setValue(null);
				showTable("ageWar");
			} else if (EditReignWarTabID.isSelected()) {
				if (ReignWarReignIDComboBox.getValue() != null && ReignWarReignIDComboBox.getValue().equals("")) {
					ReignWarReignIDComboBox.setValue(null);
				}
				if (ReignWarWarComboBox.getValue() != null && ReignWarWarComboBox.getValue().equals("")) {
					ReignWarWarComboBox.setValue(null);
				}
				StringBuilder addReignWar = new StringBuilder("INSERT INTO reign_has_war (reignID, war) VALUES('");
				String reignIDString = ReignWarReignIDComboBox.getValue();
				String war = ReignWarWarComboBox.getValue();
				addReignWar.append(reignIDString + "', '" + war + "')");
				statement.execute(addReignWar.toString());
				ReignWarReignIDComboBox.setValue(null);
				ReignWarWarComboBox.setValue(null);
				showTable("reignWar");
			}
			updateComboBox();
			checkButton();
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	// Update queries
	public void updateQuery(ActionEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();

			if (EditReignTabID.isSelected()) {
				StringBuilder addReignOne = new StringBuilder("UPDATE reign SET ");
				ArrayList<Object> reignValues = new ArrayList<Object>();
				int reignID = Integer.parseInt(ReignReignIDTextField.getText());
				String title = ReignTitleTextField.getText();
				String rulerString = null;
				if (ReignRulerComboBox.getValue() != null && !ReignRulerComboBox.getValue().equals("")) {
					rulerString = ReignRulerComboBox.getValue().toString();
				}
				String number = ReignNumberTextField.getText();
				String startString = ReignStartTextField.getText();
				String endString = ReignEndTextField.getText();
				String area = ReignAreaTextField.getText();
				List<Object> list = Arrays.asList(reignID, title, rulerString, number, startString, endString, area);
				reignValues.addAll(list);
				for (int i = 1; i < reignFields.size(); i++) {
					if (reignValues.get(i) != null && reignValues.get(i).toString().length() > 0
							&& !reignValues.get(i).toString().equals("DELETE")) {
						addReignOne.append(reignFields.get(i) + " = '" + reignValues.get(i) + "', ");
					} else if (reignValues.get(i) != null && reignValues.get(i).toString().equals("DELETE")) {
						addReignOne.append(reignFields.get(i) + " = NULL, ");
					}
				}
				StringBuilder addReign = new StringBuilder(addReignOne.substring(0, addReignOne.length() - 2));
				addReign.append(" WHERE (reignID = '" + reignID + "')");
				statement.execute(addReign.toString());
				ReignReignIDTextField.clear();
				ReignTitleTextField.clear();
				ReignRulerComboBox.setValue(null);
				ReignNumberTextField.clear();
				ReignStartTextField.clear();
				ReignEndTextField.clear();
				ReignAreaTextField.clear();
				showTable("reign");
			} else if (EditRulerTabID.isSelected()) {
				StringBuilder addRulerOne = new StringBuilder("UPDATE ruler SET ");
				ArrayList<Object> rulerValues = new ArrayList<Object>();
				int rulerID = Integer.parseInt(RulerRulerIDTextField.getText());
				String firstname = RulerFirstnameTextField.getText();
				String secondname = RulerSecondnameTextField.getText();
				String surname = RulerSurnameTextField.getText();
				String epithet = RulerEpithetTextField.getText();
				String nickname = RulerNicknameTextField.getText();
				String genderString = null;
				if (RulerGenderComboBox.getValue() != null && !RulerGenderComboBox.getValue().equals("")) {
					genderString = RulerGenderComboBox.getValue().toString();
				}
				String dynastyString = null;
				if (RulerDynastyComboBox.getValue() != null && !RulerDynastyComboBox.getValue().equals("")) {
					dynastyString = RulerDynastyComboBox.getValue().toString();
				}
				List<Object> list = Arrays.asList(rulerID, firstname, secondname, surname, epithet, nickname,
						genderString, dynastyString);
				rulerValues.addAll(list);
				for (int i = 1; i < rulerFields.size(); i++) {
					if (rulerValues.get(i) != null && rulerValues.get(i).toString().length() > 0
							&& !rulerValues.get(i).toString().equals("DELETE")) {
						addRulerOne.append(rulerFields.get(i) + " = '" + rulerValues.get(i) + "', ");
					} else if (rulerValues.get(i) != null && rulerValues.get(i).toString().equals("DELETE")) {
						addRulerOne.append(rulerFields.get(i) + " = NULL, ");
					}
				}
				StringBuilder addRuler = new StringBuilder(addRulerOne.substring(0, addRulerOne.length() - 2));
				addRuler.append(" WHERE (rulerID = '" + rulerID + "')");
				statement.execute(addRuler.toString());
				RulerRulerIDTextField.clear();
				RulerFirstnameTextField.clear();
				RulerSecondnameTextField.clear();
				RulerSurnameTextField.clear();
				RulerEpithetTextField.clear();
				RulerNicknameTextField.clear();
				RulerGenderComboBox.setValue(null);
				RulerDynastyComboBox.setValue(null);
				showTable("ruler");
			} else if (EditDynastyTabID.isSelected()) {
				StringBuilder addDynastyOne = new StringBuilder("UPDATE dynasty SET ");
				ArrayList<Object> dynastyValues = new ArrayList<Object>();
				String name = DynastyNameTextField.getText();
				String ethnicity = DynastyEthnicityTextField.getText();
				List<Object> list = Arrays.asList(name, ethnicity);
				dynastyValues.addAll(list);
				for (int i = 1; i < dynastyFields.size(); i++) {
					if (dynastyValues.get(i) != null && dynastyValues.get(i).toString().length() > 0
							&& !dynastyValues.get(i).toString().equals("DELETE")) {
						addDynastyOne.append(dynastyFields.get(i) + " = '" + dynastyValues.get(i) + "', ");
					} else if (dynastyValues.get(i) != null && dynastyValues.get(i).toString().equals("DELETE")) {
						addDynastyOne.append(dynastyFields.get(i) + " = NULL, ");
					}
				}
				StringBuilder addDynasty = new StringBuilder(addDynastyOne.substring(0, addDynastyOne.length() - 2));
				addDynasty.append(" WHERE (name = '" + name + "')");
				statement.execute(addDynasty.toString());
				DynastyNameTextField.clear();
				DynastyEthnicityTextField.clear();
				showTable("dynasty");
			} else if (EditAgeTabID.isSelected()) {
				StringBuilder addAgeOne = new StringBuilder("UPDATE age SET ");
				ArrayList<Object> ageValues = new ArrayList<Object>();
				String age = AgeAgeTextField.getText();
				String startString = AgeStartTextField.getText();
				String endString = AgeEndTextField.getText();
				List<Object> ageList = Arrays.asList(age, startString, endString);
				ageValues.addAll(ageList);
				for (int i = 1; i < ageFields.size(); i++) {
					if (ageValues.get(i) != null && ageValues.get(i).toString().length() > 0
							&& !ageValues.get(i).toString().equals("DELETE")) {
						addAgeOne.append(ageFields.get(i) + " = '" + ageValues.get(i) + "', ");
					} else if (ageValues.get(i) != null && ageValues.get(i).toString().equals("DELETE")) {
						addAgeOne.append(ageFields.get(i) + " = NULL, ");
					}
				}
				StringBuilder addAge = new StringBuilder(addAgeOne.substring(0, addAgeOne.length() - 2));
				addAge.append(" WHERE (age = '" + age + "')");
				statement.execute(addAge.toString());
				AgeAgeTextField.clear();
				AgeStartTextField.clear();
				AgeEndTextField.clear();
				showTable("age");
			} else if (EditWarTabID.isSelected()) {
				StringBuilder addWarOne = new StringBuilder("UPDATE war SET ");
				ArrayList<Object> warValues = new ArrayList<Object>();
				String war = WarWarTextField.getText();
				String startString = WarStartTextField.getText();
				String endString = WarEndTextField.getText();
				String resultString = null;
				if (WarResultComboBox.getValue() != null && !WarResultComboBox.getValue().equals("")) {
					resultString = WarResultComboBox.getValue().toString();
				}
				String mainenemy = WarMainenemyTextField.getText();
				List<Object> warList = Arrays.asList(war, startString, endString, resultString, mainenemy);
				warValues.addAll(warList);
				for (int i = 1; i < warFields.size(); i++) {
					if (warValues.get(i) != null && warValues.get(i).toString().length() > 0
							&& !warValues.get(i).toString().equals("DELETE")) {
						addWarOne.append(warFields.get(i) + " = '" + warValues.get(i) + "', ");
					} else if (warValues.get(i) != null && warValues.get(i).toString().equals("DELETE")) {
						addWarOne.append(warFields.get(i) + " = NULL, ");
					}
				}
				StringBuilder addWar = new StringBuilder(addWarOne.substring(0, addWarOne.length() - 2));
				addWar.append(" WHERE (war = '" + war + "')");
				statement.execute(addWar.toString());
				WarWarTextField.clear();
				WarStartTextField.clear();
				WarEndTextField.clear();
				WarResultComboBox.setValue(null);
				WarMainenemyTextField.clear();
				showTable("war");
			}
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		updateComboBox();
		checkButton();
	}

	// DELETE queries
	public void deleteQuery(ActionEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			if (EditReignTabID.isSelected()) {
				int reignID = Integer.parseInt(ReignReignIDTextField.getText());
				String query = ("DELETE FROM reign WHERE reignID = " + reignID);
				statement.execute(query);
				ReignReignIDTextField.clear();
				showTable("reign");
			} else if (EditRulerTabID.isSelected()) {
				int rulerID = Integer.parseInt(RulerRulerIDTextField.getText());
				String query = ("DELETE FROM ruler WHERE rulerID = " + rulerID);
				statement.execute(query);
				RulerRulerIDTextField.clear();
				showTable("ruler");
			} else if (EditDynastyTabID.isSelected()) {
				String name = DynastyNameTextField.getText();
				String query = ("DELETE FROM dynasty WHERE name = '" + name + "'");
				statement.execute(query);
				DynastyNameTextField.clear();
				showTable("dynasty");
			} else if (EditAgeTabID.isSelected()) {
				String age = AgeAgeTextField.getText();
				String query = ("DELETE FROM age WHERE age = '" + age + "'");
				statement.execute(query);
				AgeAgeTextField.clear();
				showTable("age");
			} else if (EditWarTabID.isSelected()) {
				if (WarResultComboBox.getValue() != null && WarResultComboBox.getValue().equals("")) {
					WarResultComboBox.setValue(null);
				}
				String war = WarWarTextField.getText();
				String query = ("DELETE FROM war WHERE war = '" + war + "'");
				statement.execute(query);
				WarWarTextField.clear();
				showTable("war");
			} else if (EditAgeReignTabID.isSelected()) {
				StringBuilder query = new StringBuilder("DELETE FROM age_has_reign WHERE (age = '");
				String age = AgeReignAgeComboBox.getValue();
				int reignID = Integer.parseInt(AgeReignReignIDComboBox.getValue());
				query.append(age + "') AND (reignID = '" + reignID + "')");
				statement.execute(query.toString());
				AgeReignAgeComboBox.setValue(null);
				AgeReignReignIDComboBox.setValue(null);
				showTable("ageReign");
			} else if (EditAgeWarTabID.isSelected()) {
				StringBuilder query = new StringBuilder("DELETE FROM age_has_war WHERE (age = '");
				String age = AgeWarAgeComboBox.getValue();
				String war = AgeWarWarComboBox.getValue();
				query.append(age + "') AND (war = '" + war + "')");
				statement.execute(query.toString());
				AgeWarAgeComboBox.setValue(null);
				AgeWarWarComboBox.setValue(null);
				showTable("ageWar");
			} else if (EditReignWarTabID.isSelected()) {
				StringBuilder query = new StringBuilder("DELETE FROM reign_has_war WHERE (reignID = '");
				String reignIDString = ReignWarReignIDComboBox.getValue();
				String war = ReignWarWarComboBox.getValue();
				query.append(reignIDString + "') AND (war = '" + war + "')");
				statement.execute(query.toString());
				ReignWarReignIDComboBox.setValue(null);
				ReignWarWarComboBox.setValue(null);
				showTable("reignWar");
			}
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		updateComboBox();
		checkButton();
	}

	// Verify whether a String is contains only digits or not
	public boolean verifyInt(String text) { // verify input
		boolean flag = true; // flag for valid or invalid input
		for (int i = 0; i < text.length(); i++) {
			// In case any character is not a digit
			if (!(Character.isDigit(text.charAt(i)))) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	// Verify whether a String is empty or not
	public boolean verifyEmpty(String text) { // verify input
		// In case input is empty
		if (text.length() == 0) {
			return false;
		}
		return true;
	}

	// Get the values of a String-column in a table
	public ArrayList<String> getStringData(String column, String table) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT " + column + " FROM projectdb." + table);
			while (rs.next()) {
				String string = rs.getString(column);
				data.add(string);
			}
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		return data;
	}

	// Get the values of an Integer-column in a table
	public ArrayList<Integer> getIntegerData(String column, String table) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/projectdb?autoReconnect=true&useSSL=false", "root", "Password");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT " + column + " FROM projectdb." + table);
			while (rs.next()) {
				int integer = rs.getInt(column);
				data.add(integer);
			}
			connection.close();
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		return data;
	}

	// Updating the values of the ComboBoxes after a change
	public void updateComboBox() {
		// ReignRulerComboBox
		ArrayList<String> reignRulerData = getStringData("rulerID", "ruler");
		ObservableList<String> reignRulerComboBox = FXCollections.observableArrayList();
		reignRulerComboBox.add("");
		for (int i = 0; i < reignRulerData.size(); i++) {
			reignRulerComboBox.add(reignRulerData.get(i));
		}
		ReignRulerComboBox.setItems(reignRulerComboBox);

		// RulerDynastyComboBox
		ArrayList<String> rulerDynastyData = getStringData("name", "dynasty");
		ObservableList<String> rulerDynastyComboBox = FXCollections.observableArrayList();
		rulerDynastyComboBox.add("");
		for (int i = 0; i < rulerDynastyData.size(); i++) {
			rulerDynastyComboBox.add(rulerDynastyData.get(i));
		}
		RulerDynastyComboBox.setItems(rulerDynastyComboBox);

		// AgeReignAgeComboBox
		ArrayList<String> ageReignAgeData = getStringData("age", "age");
		ObservableList<String> ageReignAgeComboBox = FXCollections.observableArrayList();
		ageReignAgeComboBox.add("");
		for (int i = 0; i < ageReignAgeData.size(); i++) {
			ageReignAgeComboBox.add(ageReignAgeData.get(i));
		}
		AgeReignAgeComboBox.setItems(ageReignAgeComboBox);

		// AgeReignReignIDComboBox
		ArrayList<String> ageReignReignIDData = getStringData("reignID", "reign");
		ObservableList<String> ageReignReignIDComboBox = FXCollections.observableArrayList();
		ageReignReignIDComboBox.add("");
		for (int i = 0; i < ageReignReignIDData.size(); i++) {
			ageReignReignIDComboBox.add(ageReignReignIDData.get(i));
		}
		AgeReignReignIDComboBox.setItems(ageReignReignIDComboBox);

		// AgeWarAgeComboBox
		ArrayList<String> ageWarAgeData = getStringData("age", "age");
		ObservableList<String> ageWarAgeComboBox = FXCollections.observableArrayList();
		ageWarAgeComboBox.add("");
		for (int i = 0; i < ageWarAgeData.size(); i++) {
			ageWarAgeComboBox.add(ageWarAgeData.get(i));
		}
		AgeWarAgeComboBox.setItems(ageWarAgeComboBox);

		// AgeWarWarComboBox
		ArrayList<String> ageWarWarData = getStringData("war", "war");
		ObservableList<String> ageWarWarComboBox = FXCollections.observableArrayList();
		ageWarWarComboBox.add("");
		for (int i = 0; i < ageWarWarData.size(); i++) {
			ageWarWarComboBox.add(ageWarWarData.get(i));
		}
		AgeWarWarComboBox.setItems(ageWarWarComboBox);

		// ReignWarReignIDComboBox
		ArrayList<String> reignWarReignIDData = getStringData("reignID", "reign");
		ObservableList<String> reignWarReignIDComboBox = FXCollections.observableArrayList();
		reignWarReignIDComboBox.add("");
		for (int i = 0; i < reignWarReignIDData.size(); i++) {
			reignWarReignIDComboBox.add(reignWarReignIDData.get(i));
		}
		ReignWarReignIDComboBox.setItems(reignWarReignIDComboBox);

		// ReignWarWarComboBox
		ArrayList<String> reignWarWarData = getStringData("war", "war");
		ObservableList<String> reignWarWarComboBox = FXCollections.observableArrayList();
		reignWarWarComboBox.add("");
		for (int i = 0; i < reignWarWarData.size(); i++) {
			reignWarWarComboBox.add(reignWarWarData.get(i));
		}
		ReignWarWarComboBox.setItems(reignWarWarComboBox);
	}
}
