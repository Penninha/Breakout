using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    public float velocity;
    public float direction;
    public Vector3 startPos;

    private void Start()
    {
        startPos = this.transform.position;
    }

    void Update ()
    {
        float h = Input.GetAxisRaw("Horizontal") * velocity * Time.deltaTime;

        transform.Translate(h, 0f, 0f);

        if (transform.position.x < -2.8f)
        {
            transform.position = new Vector3(-2.8f, transform.position.y);
        }
        else if(transform.position.x > 2.8f)
        {
            transform.position = new Vector3(2.8f, transform.position.y);
        }
	}

    public void ResetPos()
    {
        this.transform.position = startPos;
    }
}
