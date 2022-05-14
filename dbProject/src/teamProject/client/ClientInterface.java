package teamProject.client;

import java.util.List;

public interface ClientInterface {

	void loadListMoive(String jsonn);
	void loadListActor(String json);
	void loadRecentMovie(String json);
	void searchMovieInfo(String json);
	void searchActorInfo(String json);
	void sentMsg(String msg);
}
