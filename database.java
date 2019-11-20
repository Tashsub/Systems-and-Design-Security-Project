package database;
//Code that creates the databases

/*begin
    //user table
    @db = SQLite3::Database.open "database/userDb.sqlite"
    @db.execute %{CREATE TABLE User (title TEXT, forename TEXT, surname TEXT, university TEXT, PKLoginID TEXT UNIQUE, password TEXT)}

    //published article table
    @db = SQLite3::Database.open "database/publishedarticleDb.sqlite"
    @db.execute %{CREATE TABLE PublishedArticle (FKSubmissionID TEXT UNIQUE, articleTitle TEXT, articleAbstract TEXT, PKArticleLink TEXT, authors TEXT, PKArticleID TEXT)}

    //submission table
    @db = SQLite3::Database.open "database/submissionDb.sqlite"
    @db.execute %{CREATE TABLE Submission (PKSubmissionID TEXT UNIQUE, submissionTitle TEXT, submissionAbstract TEXT, submissionLink TEXT, authors TEXT, reviews TEXT, responses TEXT, verdict BOOL)}

	//article info table
    @db = SQLite3::Database.open "database/articleinfoDb.sqlite"
    @db.execute %{CREATE TABLE ArticleInfo (PKArticleID TEXT UNIQUE, journalISSN INT, volume TEXT, edition INT, pageNumRange INT)}

    //review table
    @db = SQLite3::Database.open "database/reviewDb.sqlite"
    @db.execute %{CREATE TABLE Review (anonymousID TEXT UNIQUE, reviewerSummary TEXT, typoErrors TEXT, criticisms TEXT, verdictJudgement TEXT, FKSubmissionID TEXT, response TEXT, reviewer TEXT)}

end
*/