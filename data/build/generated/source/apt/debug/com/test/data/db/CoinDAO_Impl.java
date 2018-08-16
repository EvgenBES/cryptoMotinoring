package com.test.data.db;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.RxRoom;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.test.data.entity.CoinResponse;
import io.reactivex.Flowable;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class CoinDAO_Impl implements CoinDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCoinResponse;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCoinResponse;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCoinResponse;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CoinDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCoinResponse = new EntityInsertionAdapter<CoinResponse>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `coins`(`id`,`name`,`symbol`,`rank`,`circulatingSupply`,`price`,`percentChange24h`,`marketCap`,`percentChange1h`,`volume24h`,`percentChange7d`,`image`,`quantity`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoinResponse value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSymbol() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSymbol());
        }
        stmt.bindLong(4, value.getRank());
        stmt.bindLong(5, value.getCirculatingSupply());
        stmt.bindDouble(6, value.getPrice());
        stmt.bindDouble(7, value.getPercentChange24h());
        stmt.bindLong(8, value.getMarketCap());
        stmt.bindDouble(9, value.getPercentChange1h());
        stmt.bindDouble(10, value.getVolume24h());
        stmt.bindDouble(11, value.getPercentChange7d());
        if (value.getImage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getImage());
        }
        stmt.bindDouble(13, value.getQuantity());
      }
    };
    this.__deletionAdapterOfCoinResponse = new EntityDeletionOrUpdateAdapter<CoinResponse>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `coins` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoinResponse value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCoinResponse = new EntityDeletionOrUpdateAdapter<CoinResponse>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `coins` SET `id` = ?,`name` = ?,`symbol` = ?,`rank` = ?,`circulatingSupply` = ?,`price` = ?,`percentChange24h` = ?,`marketCap` = ?,`percentChange1h` = ?,`volume24h` = ?,`percentChange7d` = ?,`image` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CoinResponse value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getSymbol() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSymbol());
        }
        stmt.bindLong(4, value.getRank());
        stmt.bindLong(5, value.getCirculatingSupply());
        stmt.bindDouble(6, value.getPrice());
        stmt.bindDouble(7, value.getPercentChange24h());
        stmt.bindLong(8, value.getMarketCap());
        stmt.bindDouble(9, value.getPercentChange1h());
        stmt.bindDouble(10, value.getVolume24h());
        stmt.bindDouble(11, value.getPercentChange7d());
        if (value.getImage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getImage());
        }
        stmt.bindDouble(13, value.getQuantity());
        stmt.bindLong(14, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM coins";
        return _query;
      }
    };
  }

  @Override
  public void insert(CoinResponse coinResponse) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCoinResponse.insert(coinResponse);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(CoinResponse coinResponse) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCoinResponse.handle(coinResponse);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(CoinResponse coinResponse) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCoinResponse.handle(coinResponse);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Flowable<List<CoinResponse>> getAll() {
    final String _sql = "SELECT * FROM coins";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, new String[]{"coins"}, new Callable<List<CoinResponse>>() {
      @Override
      public List<CoinResponse> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfSymbol = _cursor.getColumnIndexOrThrow("symbol");
          final int _cursorIndexOfRank = _cursor.getColumnIndexOrThrow("rank");
          final int _cursorIndexOfCirculatingSupply = _cursor.getColumnIndexOrThrow("circulatingSupply");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
          final int _cursorIndexOfPercentChange24h = _cursor.getColumnIndexOrThrow("percentChange24h");
          final int _cursorIndexOfMarketCap = _cursor.getColumnIndexOrThrow("marketCap");
          final int _cursorIndexOfPercentChange1h = _cursor.getColumnIndexOrThrow("percentChange1h");
          final int _cursorIndexOfVolume24h = _cursor.getColumnIndexOrThrow("volume24h");
          final int _cursorIndexOfPercentChange7d = _cursor.getColumnIndexOrThrow("percentChange7d");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfQuantity = _cursor.getColumnIndexOrThrow("quantity");
          final List<CoinResponse> _result = new ArrayList<CoinResponse>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CoinResponse _item;
            _item = new CoinResponse();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpSymbol;
            _tmpSymbol = _cursor.getString(_cursorIndexOfSymbol);
            _item.setSymbol(_tmpSymbol);
            final long _tmpRank;
            _tmpRank = _cursor.getLong(_cursorIndexOfRank);
            _item.setRank(_tmpRank);
            final long _tmpCirculatingSupply;
            _tmpCirculatingSupply = _cursor.getLong(_cursorIndexOfCirculatingSupply);
            _item.setCirculatingSupply(_tmpCirculatingSupply);
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            _item.setPrice(_tmpPrice);
            final double _tmpPercentChange24h;
            _tmpPercentChange24h = _cursor.getDouble(_cursorIndexOfPercentChange24h);
            _item.setPercentChange24h(_tmpPercentChange24h);
            final long _tmpMarketCap;
            _tmpMarketCap = _cursor.getLong(_cursorIndexOfMarketCap);
            _item.setMarketCap(_tmpMarketCap);
            final double _tmpPercentChange1h;
            _tmpPercentChange1h = _cursor.getDouble(_cursorIndexOfPercentChange1h);
            _item.setPercentChange1h(_tmpPercentChange1h);
            final double _tmpVolume24h;
            _tmpVolume24h = _cursor.getDouble(_cursorIndexOfVolume24h);
            _item.setVolume24h(_tmpVolume24h);
            final double _tmpPercentChange7d;
            _tmpPercentChange7d = _cursor.getDouble(_cursorIndexOfPercentChange7d);
            _item.setPercentChange7d(_tmpPercentChange7d);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final double _tmpQuantity;
            _tmpQuantity = _cursor.getDouble(_cursorIndexOfQuantity);
            _item.setQuantity(_tmpQuantity);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
