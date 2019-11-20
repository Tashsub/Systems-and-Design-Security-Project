/*package database;

@review = SQLite3::Database.open "database/reviewDb.sqlite"

def getanonymousID(PKSubmissionID) 
	return (@review.execute "SELECT PKArticleID FROM Review WHERE PKSubmissionID LIKE '#{PKSubmissionID}'")
end

def getreviewerSummary(anonymousID) 
	return (@review.execute "SELECT reviewerSummary FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def gettypoErrors(anonymousID) 
	return (@review.execute "SELECT typoErrors FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def getcriticisms(anonymousID) 
	return (@review.execute "SELECT criticisms FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def getverdictJudgement(anonymousID) 

	return (@review.execute "SELECT verdictJudgement FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def getFKSubmissionID(anonymousID) 
	return (@review.execute "SELECT FKSubmissionID FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def getresponse(anonymousID) 
	return (@review.execute "SELECT response FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

def getreviewer(anonymousID) 
	return (@review.execute "SELECT reviewer FROM Review WHERE anonymousID LIKE '#{anonymousID}'")
end

*/