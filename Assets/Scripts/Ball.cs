using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{
    private int vertical;
    private int horizontal;
    private Vector3 startPos;
    private Rigidbody2D rb;
    
    public float force;

	// Use this for initialization
	void Start ()
    {
        rb = this.GetComponent<Rigidbody2D>();
        startPos = this.transform.position;
        StartGame();
    }

    private void FixedUpdate()
    {
        Vector2 directionToMove = new Vector3(horizontal, vertical);
        rb.position += directionToMove * force * Time.deltaTime;
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag == "Player")
        {
            vertical = 1;

            if(Input.GetAxisRaw("Horizontal") != 0)
            {
                horizontal = (int)Input.GetAxisRaw("Horizontal");
            }                  
        }

        if(collision.gameObject.tag == "Wall")
        {
            if (collision.gameObject.name == "LeftWall")
            {
                horizontal = 1;
            }
            else if (collision.gameObject.name == "RightWall")
            {
                horizontal = -1;
            }
            else
            {
                vertical = -1;
            }
        }

        if(collision.gameObject.tag == "Catcher")
        {
            this.transform.position = startPos;
            StartGame();
            GameManager.Instance.LoseLife();
        }

        if(collision.gameObject.tag == "Block")
        {
            vertical *= -1;
            GameManager.Instance.GivePoints(100, collision.gameObject);
            Destroy(collision.gameObject);
        }
    }

    void StartGame()
    {
        if (Random.Range(1, 100) % 2 == 0)
        {
            horizontal = -1;
        }
        else
        {
            horizontal = 1;
        }

        vertical = -1;
    }
}
