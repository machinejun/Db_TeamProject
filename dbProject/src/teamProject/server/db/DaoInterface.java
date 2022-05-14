package teamProject.server.db;

import java.util.List;

public interface DaoInterface<T extends Dto> {
	
	// 접속시
	List<T> loadListMoive();

	List<T> loadListActor();

	List<T> loadRecentMovie();

	T searchMovieInfo(String movieName);
	// text로 받음 <<< movieDto, 해당 영화의 출연 배우(actor) + 배역(role)

	T searchActorInfo(String actorName);
	// "" <<< actorDto, 해당 배우 정보(actor) + 배우가 출연한 영화 이름

}