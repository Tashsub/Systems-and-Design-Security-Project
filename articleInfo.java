/*package database;

@articleinfo = SQLite3::Database.open "database/articleinfoDb.sqlite"


def getPKarticleID(FKarticleID) 
	return (@articleinfo.execute "SELECT PKArticleID FROM ArticleInfo WHERE FKarticleID LIKE '#{FKarticleID}'")
end

def getjournalISSN(PKArticleID) 
	return (@articleinfo.execute "SELECT journalISSN FROM ArticleInfo WHERE PKArticleID LIKE '#{PKArticleID}'")
end

def getvolume(PKArticleID) 
	return (@articleinfo.execute "SELECT volume FROM ArticleInfo WHERE PKArticleID LIKE '#{PKArticleID}'")
end

def getedition(PKArticleID) 
	return (@articleinfo.execute "SELECT edition FROM ArticleInfo WHERE PKArticleID LIKE '#{PKArticleID}'")
end

def getpageNumRange(PKArticleID) 
	return (@articleinfo.execute "SELECT pageNumRange FROM ArticleInfo WHERE PKArticleID LIKE '#{PKArticleID}'")
end

*/