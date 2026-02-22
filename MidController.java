package cse213projects.spring2024.midterm_2110075_sec6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MidController {
    @FXML
    private TextField noofAuthorsTF;
    @FXML
    private Label oyputLabel;
    @FXML
    private ComboBox<String> typeCB;
    @FXML
    private TextField authorTF;
    @FXML
    private DatePicker publicationDatePicker;
    @FXML
    private CheckBox ciatiationStatusYes;
    @FXML
    private TextField titleTF;
    @FXML
    private TableColumn<Article, String> StatusColumn;
    @FXML
    private TableView<Article> articleTable;
    @FXML
    private TableColumn<Article, LocalDate> publicationDateColumn;
    @FXML
    private TableColumn<Article, String> TitleColumn;
    @FXML
    private TableColumn<Article, String> typeColumn;
    @FXML
    private TableColumn<Article, String> authorColumn;
    @FXML
    private TableColumn<Article, Integer> noOfAuthorsColumn;
    @FXML
    private CheckBox searchciatiationStatusYesforfiltering;
    @FXML
    private ComboBox<String> searchTypeCB;
    @FXML
    private TextField toYearTF;
    @FXML
    private TextField fromYearTF;
    @FXML
    private Label highestArticleTextField;

    @FXML
    public void initialize() {
        typeCB.getItems().addAll("Review", "Book", "Case");
        searchTypeCB.getItems().addAll("Review", "Book", "Case");
        TitleColumn.setCellValueFactory((new PropertyValueFactory<>("title")));
        authorColumn.setCellValueFactory((new PropertyValueFactory<>("author")));
        typeColumn.setCellValueFactory((new PropertyValueFactory<>("type")));
        StatusColumn.setCellValueFactory((new PropertyValueFactory<>("status")));
        publicationDateColumn.setCellValueFactory((new PropertyValueFactory<>("publicationDate")));
        noOfAuthorsColumn.setCellValueFactory((new PropertyValueFactory<>("noofAuthors")));

    }

    private ArrayList<Article> articles = new ArrayList<>();

    @FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        String author, title, type;
        LocalDate publicationDate;
        int noofAuthors = 0;


        author = authorTF.getText();
        title = titleTF.getText();
        type = typeCB.getValue();
        publicationDate = publicationDatePicker.getValue();


        String citationStatus = "No";
        if (ciatiationStatusYes.isSelected()) citationStatus = "Yes";
        try {
            noofAuthors = Integer.parseInt(noofAuthorsTF.getText());
        } catch (Exception e) {
            oyputLabel.setText("Please enter a proper author count");
            return;
        }

        Article article = new Article(title, type, author, publicationDate, citationStatus, noofAuthors);
        articles.add(article);
        oyputLabel.setText("Article added");
        articleTable.getItems().clear();
        articleTable.getItems().addAll(articles);
    }

    @FXML
    public void searchArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        ArrayList<Article> filteredArticles = new ArrayList<>();
        String searchType = searchTypeCB.getValue();
        String searchCitationStaus = "No";
        if (searchciatiationStatusYesforfiltering.isSelected()) searchCitationStaus = "Yes";
        {
            for (Article article : articles) {
                if ((article.getType().equals(searchType)) && (article.getStatus().equals(searchCitationStaus))) {
                    filteredArticles.add(article);


                }
            }
            articleTable.getItems().clear();
            articleTable.getItems().addAll(filteredArticles);

        }

    }

    @FXML
    public void yearFilterButtonMouseOnClicked(ActionEvent actionEvent) {
        if (fromYearTF.getText().isBlank()) {
            oyputLabel.setText("Please enter a starting year to search");
            return;
        }
        if (toYearTF.getText().isBlank()) {
            oyputLabel.setText("Please enter an ending year to search");
            return;
        }
        int fromYear = Integer.parseInt(fromYearTF.getText());
        int toYear = Integer.parseInt(toYearTF.getText());
        ArrayList<Article> filteredArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.getPublicationYear() >= fromYear && article.getPublicationYear() <= toYear) {
                filteredArticles.add(article);
            }
        }
        articleTable.getItems().clear();
        articleTable.getItems().addAll(filteredArticles);
    }

    @FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        Article highighestarticle = articles.getFirst();
        for (Article article : articles ) {
            if (article.getNoofAuthors()> highighestarticle.getNoofAuthors()) {
                highighestarticle = article ;

            }
        }
        highestArticleTextField.setText(highighestarticle.toString());
    }
}