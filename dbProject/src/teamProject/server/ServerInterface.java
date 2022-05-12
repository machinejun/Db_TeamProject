package teamProject.server;

import java.util.List;

public interface ServerInterface{
	// 접속시
	List loadListMoive();
	List loadListActor();
	List loadRecentMovie();
	
	Dto searchMovieInfo (String movieName);
	// text로 받음  <<< movieDto, 해당영화에 해당하는 배우 + 배역
	
	Dto searchActorInfo(String actorName);
	// "" <<< actorDto, 해당배우가 출연한 영화 이름
	void actionProtocol(String message);
}
