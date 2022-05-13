package teamProject.server.db;

import java.util.List;

public interface DaoInterface<T extends Dto> {
	
	// 접속시
	List<T> loadListMoive();

	List<T> loadListActor();

	List<T> loadRecentMovie();

	T SearchMovieInfo(String movieName);
	// text로 받음 <<< movieDto, 해당 영화에 해당하는 배우(actor) + 배역(role)

	T SearchActorInfo(String actorName);
	// "" <<< actorDto, 해당 배우 정보 + 배우가 출연한 영화 이름

}