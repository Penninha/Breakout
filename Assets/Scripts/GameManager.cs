using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    #region SINGLETON

    private static GameManager instance;
    public static GameManager Instance
    {
        get { return instance; }
        set { instance = value; }
    }

    private void Awake()
    {
        if(instance == null)
        {
            instance = this;
        }
        else
        {
            Destroy(this.gameObject);
        }
    }

    #endregion

    public int score;
    public int lives;

    public GameObject gameOverPanel;    
    public GameObject winPanel;
    public GameObject startPanel;

    public Player player;

    public Text gameOverScoreText;
    public Text winScoreText;
    public Text scoreText;
    public Text livesText;

    private List<GameObject> levelBlocks = new List<GameObject>();
    private bool isStarted = false;

    // Use this for initialization
    void Start ()
    {
        if (Time.time <= 0)
        {
            Time.timeScale = 0f;
            startPanel.SetActive(true);
        }
        else
        {
            StartGame();
        }
    }

    private void Update()
    {
        if (isStarted)
        {
            GameOver();
        }
    }

    public void LoseLife()
    {
        lives--;
        DrawLives();
    }

    public void GivePoints(int points, GameObject block)
    {
        score += points;
        scoreText.text = score.ToString();
        levelBlocks.Remove(block);
    }

    public void StartGame()
    {
        score = 0;
        lives = 4;
        DrawLives();        
        scoreText.text = score.ToString();
        gameOverPanel.SetActive(false);
        winPanel.SetActive(false);
        FindLevelBlocks();
        isStarted = true;
        Time.timeScale = 1f;
        startPanel.SetActive(false);
    }

    public void RestartGame()
    {
        Scene thisScene = SceneManager.GetActiveScene();
        SceneManager.LoadScene(thisScene.buildIndex);
        Time.timeScale = 1f;
    }

    private void GameOver()
    {
        if(lives <= 0)
        {
            Time.timeScale = 0;
            gameOverScoreText.text = score.ToString();
            gameOverPanel.SetActive(true);
        }
        else if(levelBlocks.Count <= 0)
        {
            Time.timeScale = 0;
            winScoreText.text = score.ToString();
            winPanel.SetActive(true);
        }
    }

    private void FindLevelBlocks()
    {
        GameObject[] levelObjects = FindObjectsOfType<GameObject>();
        foreach (GameObject levelObject in levelObjects)
        {
            if (levelObject.tag == "Block")
            {
                levelBlocks.Add(levelObject);
            }
        }
    }

    private void DrawLives()
    {
        livesText.text = "";
        for (int i = 1; i < lives; i++)
        {
            livesText.text += "-";
        }
    }
}
