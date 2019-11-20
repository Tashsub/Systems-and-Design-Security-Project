/*package database;

@publishedarticle = SQLite3::Database.open "database/publishedarticleDb.sqlite"

def getFKSubmissionID(loginID, surname, forename) 
	return (@publishedarticle.execute "SELECT FKSubmissionID FROM PublishedArticle WHERE loginID LIKE '#{loginID}' && surname LIKE '#{surname}' && forename LIKE '#{forename}'")
end

def getarticleTitle(surname, forename) 
	return (@publishedarticle.execute "SELECT articleTitle FROM PublishedArticle WHERE surname LIKE '#{loginID}'")
end

def getarticleAbstract(articleTitle) 
	return (@publishedarticle.execute "SELECT articleAbstract FROM PublishedArticle WHERE articleTitle LIKE '#{articleTitle}'") 
end

def getPKArticlelink(articleTitle)
	return (@publishedarticle.execute "SELECT PKArticlelink FROM PublishedArticle WHERE articleTitle LIKE '#{articleTitle}'")
end 

def getauthors(articleTitle)
	return (@publishedarticle.execute "SELECT authors FROM PublishedArticle WHERE articleTitle LIKE '#{articleTitle}'")
end

def getFKArticleID(articleTitle)
	return (@publishedarticle.execute "SELECT FKArticleID FROM PublishedArticle WHERE articleTitle LIKE '#{articleTitle}'")
end
*/