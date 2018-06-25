package com.example.student.tilepuzzle;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import es.dmoral.toasty.Toasty;

public class GameActivity extends AppCompatActivity {
    private Button[][] buttons = new Button[3][3];
    private Button replayButton, solveButton;

    private ArrayList<Integer> nums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        replayButton = findViewById(R.id.button_replay);
        replayButton.setTextColor(Color.WHITE);
        replayButton.setText("Shuffle");

        solveButton = findViewById(R.id.button_solve);
        solveButton.setTextColor(Color.WHITE);

        buttons[0][0] = findViewById(R.id.button_a1);
        buttons[0][1] = findViewById(R.id.button_a2);
        buttons[0][2] = findViewById(R.id.button_a3);

        buttons[1][0] = findViewById(R.id.button_b1);
        buttons[1][1] = findViewById(R.id.button_b2);
        buttons[1][2] = findViewById(R.id.button_b3);

        buttons[2][0] = findViewById(R.id.button_c1);
        buttons[2][1] = findViewById(R.id.button_c2);
        buttons[2][2] = findViewById(R.id.button_c3);

        setValue();
        
        //row a listeners
        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(0,0);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(0,1);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(0,2);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        //row b listeners
        buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(1,0);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(1,1);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(1,2);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        //row c listeners
        buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(2,0);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }
            }
        });

        buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(2,1);

                if (win()) {
                    Toasty.success(GameActivity.this, "You win!", Toast.LENGTH_SHORT, true).show();

                    replayButton.setVisibility(View.VISIBLE);

                    buttons[0][0].setEnabled(false);
                    buttons[0][1].setEnabled(false);
                    buttons[0][2].setEnabled(false);

                    buttons[1][0].setEnabled(false);
                    buttons[1][1].setEnabled(false);
                    buttons[1][2].setEnabled(false);

                    buttons[2][0].setEnabled(false);
                    buttons[2][1].setEnabled(false);
                    buttons[2][2].setEnabled(false);
                }

            }
        });

        buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(2,2);

            }
        });

        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EightPuzzle puzzle = new EightPuzzle();
                int[][] nums = getNums();

                solveButton.setEnabled(false);

                buttons[0][0].setEnabled(false);
                buttons[0][1].setEnabled(false);
                buttons[0][2].setEnabled(false);

                buttons[1][0].setEnabled(false);
                buttons[1][1].setEnabled(false);
                buttons[1][2].setEnabled(false);

                buttons[2][0].setEnabled(false);
                buttons[2][1].setEnabled(false);
                buttons[2][2].setEnabled(false);

                Stack<EightPuzzleBoard> moves = puzzle.aStarSearch(nums, 0);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toasty.error(GameActivity.this, "You Lose!", Toast.LENGTH_SHORT, true).show();
                    }
                }, 500 * moves.size());

                for(int i = 0; moves.size() > 0; i++) {
                    final int[][] t = moves.pop().getPuzzle();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setValue(t);
                        }
                    }, 500 * i);
                }
            }
        });

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue();

                solveButton.setEnabled(true);

                Toasty.success(GameActivity.this, "Successfully shuffled!", Toast.LENGTH_SHORT, true).show();

                buttons[0][0].setEnabled(true);
                buttons[0][1].setEnabled(true);
                buttons[0][2].setEnabled(true);

                buttons[1][0].setEnabled(true);
                buttons[1][1].setEnabled(true);
                buttons[1][2].setEnabled(true);

                buttons[2][0].setEnabled(true);
                buttons[2][1].setEnabled(true);
                buttons[2][2].setEnabled(true);

            }
        });

    }

    public void setValue() {
        for (int i = 0; i < 9; i++) {
            nums.add(i);
        }

        do {
            Collections.shuffle(nums);
        } while (!isSolvable(nums));

        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {

                buttons[r][c].setText("" + nums.remove(0));
            }
        }

        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {

                if (buttons[r][c].getText().equals("0")) {
                    buttons[r][c].setText("");
                }
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j].setTextColor(Color.WHITE);
            }
        }

    }

    public void setValue(int[][] nums) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("" + (nums[r][c] == 0 ? "" : nums[r][c]));
            }
        }
    }

    public void move(int x, int y) {
        if (isInBounds(x - 1, y) && buttons[x - 1][y].getText().equals("")) {
            buttons[x - 1][y].setText(buttons[x][y].getText());
            buttons[x][y].setText("");
        }

        if (isInBounds(x + 1, y) && buttons[x + 1][y].getText().equals("")) {
            buttons[x + 1][y].setText(buttons[x][y].getText());
            buttons[x][y].setText("");
        }

        if (isInBounds(x, y - 1) && buttons[x][y - 1].getText().equals("")){
            buttons[x][y - 1].setText(buttons[x][y].getText());
            buttons[x][y].setText("");
        }

        if (isInBounds(x, y + 1) && buttons[x][y + 1].getText().equals("")) {
            buttons[x][y + 1].setText(buttons[x][y].getText());
            buttons[x][y].setText("");
        }
    }

    public boolean isInBounds(int x, int y) {
        return (x >= 0 && x < buttons[0].length) && (y >= 0 && y < buttons.length);
    }

    public boolean win() {
        int num = 0;
        String[] WIN = {"", "1", "2", "3", "4", "5", "6", "7", "8"};
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                if (!(buttons[r][c].getText().equals(WIN[num]))) {
                    return false;
                }
                num++;
            }
        }

        solveButton.setEnabled(false);

        return true;
    }

    public boolean isSolvable(ArrayList<Integer> nums) {
        int inversions = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 9; j++) {
                if(nums.get(j) != 0) {
                    if (nums.get(i) > nums.get(j)) {
                        inversions++;
                    }
                }
            }
        }
        return (inversions & 1) == 0;
    }

    public int[][] getNums() {
        int[][] result = new int[3][3];

        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                if (buttons[r][c].getText().equals("")) {
                    result[r][c] = 0;
                }
                else {
                    result[r][c] = Integer.parseInt((String) buttons[r][c].getText());
                }
            }
        }

        return result;
    }
}
