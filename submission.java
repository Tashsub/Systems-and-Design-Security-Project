/*package database;

@submission = SQLite3::Database.open "database/submissionDb.sqlite"

def getPKSubmissionID(FKSubmissionID) 
	return (@submission.execute "SELECT PKSubmissionID FROM Submission WHERE FKSubmissionID LIKE '#{FKSubmissionID}'}'")
end

def getsubmissionTitle(PKSubmissionID) 
	return (@submission.execute "SELECT submissionTitle FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'")
end

def getsubmissionAbstract(PKSubmissionID) 
	return (@submission.execute "SELECT submissionAbstract FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'") 
end

def getsubmissionlink(PKSubmissionID)
	return (@submission.execute "SELECT submissionLink FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'")
end 

def getreviews(PKSubmissionID)
	return (@submission.execute "SELECT reviews FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'")
end

def getresponses(PKSubmissionID)
	return (@submission.execute "SELECT responses FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'")
end

def getverdict(PKSubmissionID)
	return (@submission.execute "SELECT verdict FROM Submission WHERE PKSubmissionID LIKE '#{PKSubmissionID}'}'")
end

*/