package hangman.businessLogic;

import java.util.UUID;

public interface IGameRepository {

	public void update(UUID id, GameBean game);

	public void add(UUID id, GameBean game);

	public GameBean getGameById(UUID id);

	public boolean isEmpty();

	public boolean contains(UUID id);

}
